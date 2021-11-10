/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;
import com.sun.net.httpserver.*;
import java.net.*;
import java.sql.*;
import java.io.*;  
import com.sun.net.httpserver.HttpServer;
/**
 *
 * @author fausto
 */

public class Login implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
    String query = exchange.getRequestURI().getQuery();
    String [] keyValues = query.split("&");
    String usuario = keyValues[0].split("=")[1];
    String pass = keyValues[1].split("=")[1];
        System.out.println();
    }

     public static boolean logUsuario(Usuario usuarioent)throws Exception{
         Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elpistolero","root","root");
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
