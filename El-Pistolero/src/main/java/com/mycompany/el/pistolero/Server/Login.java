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
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elpistolero","root","root");
        }
        catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        URI uri = exchange.getRequestURI();
        String name = new File(uri.getPath()).getName();
        OutputStream out = exchange.getResponseBody();
        String query = exchange.getRequestURI().getQuery();
        String pass = "NULL";
        String usuario = "NULL";
        if(query.equals("usr=&pass=")){
            out.close();
        }
        else {
            String [] keyValues = query.split("&");
            usuario = keyValues[0].split("=")[1];
            pass = keyValues[1].split("=")[1];
            System.out.println("passw "+pass);
            System.out.println("usr "+usuario);
            Usuario usuarioEntrada = new Usuario();
            usuarioEntrada.setUsrname(usuario);
            usuarioEntrada.setPassw(pass);
            try {
                if(logUsuario(conn,usuarioEntrada)== true){
                    String verdadera = "OK!";
                    byte[] respuesta = verdadera.getBytes();
                    exchange.sendResponseHeaders(200, respuesta.length);
                    out.write(respuesta);
                }
                else{
                    Statement stmt0  = conn.createStatement();
                    Statement stmt1  = conn.createStatement();
                    Statement stmt2  = conn.createStatement();
                    Statement stmt3  = conn.createStatement();
                    String sql2 = "SELECT `veceslog` FROM `usuario` WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                    String sql5 = "SELECT `veceslog` FROM `usuario` WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                    System.out.println(sql2);
                    ResultSet rs = stmt0.executeQuery(sql2);
                    Boolean rs2 = stmt1.execute(sql5);
                    if(rs2==true){
                        String sql3 = "UPDATE `Usuario`\n" +
                        "SET veceslog = veceslog + 1\n" +
                        " WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                        System.out.println(sql3);
                        Boolean rs3 = stmt2.execute(sql3);
                        rs.next();
                        if(rs.getInt(1)>=3){
                            String verdadera = "Has intentado logearte con una contraseña incorrecta muchas veces, porfavor espera 30 segundos.";
                            byte[] respuesta = verdadera.getBytes();
                            exchange.sendResponseHeaders(200, respuesta.length);
                            out.write(respuesta);
                            Thread.sleep(30000);
                            String sql4 = "UPDATE `Usuario`\n" +
                            "SET veceslog = 0" +
                            " WHERE username = '"+usuarioEntrada.getUsrname()+"' ;";
                            stmt3.execute(sql4);
                        }
                        else {
                            String verdadera = "Usuario o contraseña incorrecto, intentalo devuelta!";
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
