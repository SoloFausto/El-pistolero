/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author fausto
 */
public class Registro implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
    String query = exchange.getRequestURI().getQuery();
    String [] keyValues = query.split("&");
    String usuario = keyValues[0].split("=")[1];
    String pass = keyValues[1].split("=")[1];
        System.out.println();
    }

     public static void regUsuario(Usuario regusuario)throws Exception{
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/elpistolero","root","root");
    Statement stmt  = conn.createStatement();
    String sql = "INSERT INTO `Usuario`(`username`, `email`, `passw`, `nombre`)" +
    "VALUES ('"+regusuario.getUsrname()+"', '"+ regusuario.getEmail()+"', '"+ regusuario.getPassw()+"', '"+ regusuario.getNombre()+"');";
    System.out.println(sql);
    stmt.execute(sql);
    }
}