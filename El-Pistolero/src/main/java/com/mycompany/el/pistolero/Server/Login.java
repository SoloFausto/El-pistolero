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
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elpistolero","root","root");
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
                else{
                    Statement stmt0  = conn.createStatement();   
                    Statement stmt1  = conn.createStatement(); // si no creo statements distintos para cada query me da error
                    Statement stmt2  = conn.createStatement();
                    Statement stmt3  = conn.createStatement();
                    String sql2 = "SELECT `veceslog` FROM `usuario` WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                    System.out.println(sql2);
                    ResultSet rs = stmt3.executeQuery(sql2);
                    rs.next();
                    Boolean rs2 = stmt1.execute(sql2);
                    System.out.println(rs2);
                    if(rs2 == true){                           // Con este if nos aseguramos que el nombre de usuario exista en la base de datos
                        String sql3 = "UPDATE `Usuario`\n" +
                        "SET veceslog = veceslog + 1\n" +
                        " WHERE username = '"+usuarioEntrada.getUsrname()+"' ;"; // Le sumamos +1 a la cantidad de intentos que lleva el usuario.
                        System.out.println(sql3);
                        stmt2.execute(sql3);
                        if(rs.getInt(1)>=3){ // si el usuario lleva mas de 3 intentos, le mandamos un mensaje y no aceptamos mas requests por 30 segundos.
                            String verdadera = "Has intentado logearte con una contraseña incorrecta muchas veces, porfavor espera 30 segundos.";
                            byte[] respuesta = verdadera.getBytes();
                            exchange.sendResponseHeaders(200, respuesta.length);
                            out.write(respuesta);
                            Thread.sleep(30000);
                            String sql4 = "UPDATE `Usuario`\n" +
                            "SET veceslog = 0" +
                            " WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                            stmt3.execute(sql4);   // Despues de los 30 segundos reseteamos los intentos que el usuario lleva.
                        }
                        else {
                            String verdadera = "Usuario o contraseña incorrecto";  // El usuario no existe.
                            byte[] respuesta = verdadera.getBytes();
                            exchange.sendResponseHeaders(200, respuesta.length);
                            out.write(respuesta);
                        }
                    }
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
