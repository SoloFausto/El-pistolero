/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;
import com.sun.net.httpserver.*;
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
        try { // Nos conectamos a la base sql (aveces hay que cambiar el puerto)
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elpistolero","root","root");
        }
        catch (SQLException ex) {
                String verdadera = "Error connectandose a la base de datos!";
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
                    String loginCorrecto = "Bienvenido usuario!";
                    byte[] loginRespuestaOk = loginCorrecto.getBytes();
                    exchange.sendResponseHeaders(200, loginRespuestaOk.length);
                    out.write(loginRespuestaOk);                               // Le mandamos un OK a nuestro cliente
                }
                else{
                    String loginIncorrecto = "Contraseña o nombre de usuario incorrecto!";
                    byte[] loginRespuestaInc = loginIncorrecto.getBytes();
                    exchange.sendResponseHeaders(200, loginRespuestaInc.length);
                    out.write(loginRespuestaInc);
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
}
