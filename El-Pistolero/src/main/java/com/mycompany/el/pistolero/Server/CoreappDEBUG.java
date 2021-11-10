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
public class CoreappDEBUG {

public static void main(String[] args) throws Exception{
    //ServerSocket serverSocket = new ServerSocket(6666);
    //Socket clientSocket = new Socket("127.0.0.1", 6666);
    //Socket clientSocket = serverSocket.accept();
    //PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    //BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    HttpServer server = HttpServer.create(new InetSocketAddress(8080),0);
    server.createContext("/login",new Login());
    server.createContext("/registro",new Registro());
    System.out.println("###########SETUP TERMINADO, EMPEZANDO WHILE#############");

            Usuario usuarioent = new Usuario();
                System.out.println("Creado un nuevo usuario");
            usuarioent.setUsrname(in.readLine());
                System.out.println("leyendo usrname");
            usuarioent.setPassw(in.readLine());
                System.out.println("leyendo passw");
            usuarioent.setEmail(in.readLine());
            System.out.println("leyendo email");
            usuarioent.setNombre(in.readLine());
            System.out.println("leyendo nombre");
            String eleccion = in.readLine();
            
            System.out.println(eleccion);
            if(eleccion.equals("1")){
                if(logUsuario(conn,usuarioent)==false){
                    msj(out,"UsrNC");
                }
                else if (logUsuario(conn,usuarioent)==true){
                    msj(out,"UsrSC");
                }
            }
            else if (eleccion.equals("2")){
                regUsuario(conn,usuarioent);
            }
        
        
    }



//static void msj(PrintWriter out,String str){
  //   out.println(str);
    //}
  
}