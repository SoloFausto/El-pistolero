/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;
/**
 *
 * @author fausto
 */
import java.net.*;
import java.sql.*;
import java.io.*;  
import com.sun.net.httpserver.HttpServer;

public class Coreapp {

public static void main(String[] args) throws Exception{
    ServerSocket serverSocket = new ServerSocket(6666);
    //Socket clientSocket = new Socket("127.0.0.1", 6666);
    Socket clientSocket = serverSocket.accept();
    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/elpistolero","root","root");
    System.out.println("###########SETUP TERMINADO, EMPEZANDO WHILE#############");
        while(true){
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
        
    }

public static void regUsuario(Connection conn,Usuario regusuario)throws Exception{
    Statement stmt  = conn.createStatement();
    String sql = "INSERT INTO `Usuario`(`username`, `email`, `passw`, `nombre`)" +
    "VALUES ('"+regusuario.getUsrname()+"', '"+ regusuario.getEmail()+"', '"+ regusuario.getPassw()+"', '"+ regusuario.getNombre()+"');";
    System.out.println(sql);
    stmt.execute(sql);
    }

public static boolean logUsuario(Connection conn, Usuario usuarioent)throws Exception{
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

static void msj(PrintWriter out,String str){
     out.println(str);
    }
  
}