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
            String root = "A:/J/INDEX.html";
       File html = new File (root);
    String query = exchange.getRequestURI().getQuery();
    String [] keyValues = query.split("&");
    String usuario = keyValues[0].split("=")[1];
    String pass = keyValues[1].split("=")[1];
        System.out.println();
        String resultado = "pene";
          exchange.sendResponseHeaders(200, 0);
      OutputStream os = exchange.getResponseBody();
      FileInputStream fs = new FileInputStream(html);
      final byte[] buffer = new byte[0x10000];
      int count = 0;
      while ((count = fs.read(buffer)) >= 0) {
        os.write(buffer,0,count);
    }
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
