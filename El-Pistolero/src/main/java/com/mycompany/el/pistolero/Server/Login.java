/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;
import com.sun.net.httpserver.*;
import java.net.*;
import java.sql.*;
import java.io.*;  
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author fausto
 */

public class Login implements HttpHandler{
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        Connection conn = null;
        OutputStream out = exchange.getResponseBody();
        try { // Nos conectamos a la base sql
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/elpistolero","root","root");
        }
        catch (SQLException ex) {
                String verdadera = "Se ha producido un error interno!";
                byte[] respuesta = verdadera.getBytes();
                exchange.sendResponseHeaders(200, respuesta.length);
                out.write(respuesta);
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        String query = exchange.getRequestURI().getQuery();//recibimos la URI de uno de los clientes.
        String pass = "NULL";
        String usuario = "NULL";
        if(query.equals("usr=&pass=")){ // Si la URI no contiene datos de Login, la ignoramos
            out.close();
        }
        else { // si contiene datos de login: los separamos en 2 diferentes variables
            String [] keyValues = query.split("&");
            usuario = keyValues[0].split("=")[1];
            pass = keyValues[1].split("=")[1];
            System.out.println("passw "+pass);
            System.out.println("usr "+usuario);
            Usuario usuarioEntrada = new Usuario(); // creamos un nuevo usuario con las 2 variables que separamos
            usuarioEntrada.setUsrname(usuario);
            usuarioEntrada.setPassw(pass);
            try {
                if(logUsuario(conn,usuarioEntrada)== true){ // Llamamos a nuestro metodo para ver si el usuario es correcto o no
                    String verdadera = "OK!";
                    byte[] respuesta = verdadera.getBytes();
                    exchange.sendResponseHeaders(200, respuesta.length);
                    out.write(respuesta);                               // Le mandamos un OK a nuestro cliente
                     String sql_reset_veces = "UPDATE `Usuario`\n" +
                        "SET veceslog = 0\n" +
                        " WHERE username = '"+usuarioEntrada.getUsrname()+"' ;"; 
                      Statement stmt  = conn.createStatement();
                      stmt.execute(sql_reset_veces);  // Reseteamos los intentos del usuario.
                }
                else if(verusrblk(conn,usuarioEntrada)==true){
                    String sql1 = "SELECT `veceslog` FROM `usuario` WHERE username = '"+usuarioEntrada.getUsrname()+"';";
                    String sql2 = """
                                  UPDATE `Usuario`
                                  SET veceslog = veceslog + 1 WHERE username = '"""+usuarioEntrada.getUsrname()+"';";
                    
                    
                            

                }
            }
            catch (Exception ex) {
                String verdadera = "Se ha producido un error interno!";
                byte[] respuesta = verdadera.getBytes();
                exchange.sendResponseHeaders(200, respuesta.length);
                out.write(respuesta);
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public static boolean logUsuario(Connection conn,Usuario usuarioent)throws Exception{
        Statement stmt  = conn.createStatement();
        String sql = "SELECT `username`,`passw` FROM `Usuario`\n" +
        " WHERE username = '"+usuarioent.getUsrname()+"'" +
        "  AND passw = '"+usuarioent.getPassw()+"' ;";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next() == false){
            return false;
        }
        else{
            return true;
        }
    }
        public static boolean verusrblk(Connection conn,Usuario usuarioent)throws Exception{
        Statement stmt  = conn.createStatement();
        String sql = "SELECT `username` FROM `Usuario`\n" +
        " WHERE username = '"+usuarioent.getUsrname()+"' ;";
        System.out.println(sql);
        ResultSet rs = stmt.executeQuery(sql);
        if (rs.next() == false){
            return false;
        }
        else{
            return true;
        }
    }
}
