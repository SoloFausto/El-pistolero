/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;
/**
 *
 * @author fausto
 */
import com.sun.net.httpserver.*;
import java.net.*;
import java.sql.*;
import java.io.*;  
import java.util.concurrent.Executors;
import java.util.concurrent.Executor;
public class Coreapp {

public static void main(String[] args) throws Exception{
    HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
    server.createContext("/login",new Login());
    server.createContext("/registro",new Registro());
    Executor executor = Executors.newFixedThreadPool(1);
    server.setExecutor(executor);
    server.start();

    }

}