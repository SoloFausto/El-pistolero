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
public class NewClass {
            public static void main(String[] args) throws Exception{
                        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/elpistolero","root","root");
                Usuario usuario2 = new Usuario("kkkusrname","kkpassw","kkkkkkkkk","kkk");

//String sql = "SELECT * FROM Usuario";
            System.out.println("Terminado el setup");
            //ResultSet rs = stmt.executeQuery(sql);
           //while(rs.next()){
          //                  System.out.println(rs.getString("usrname")+rs.getString("email")+rs.getString("passw")+rs.getString("nombre"));
            //}
                System.out.println(LogUsuario(conn,usuario2));
            }
            
            
            
            public static void RegUsuario(Connection conn,Usuario regusuario)throws Exception{
Statement stmt  = conn.createStatement();
        String sql = "INSERT INTO Usuario " +
"VALUES ('"+regusuario.getUsrname()+"', '"+ regusuario.getEmail()+"', '"+ regusuario.getPassw()+"', '"+ regusuario.getNombre()+"');";
                       System.out.println(sql);
       stmt.execute(sql);


    }
        public static boolean LogUsuario(Connection conn, Usuario usuarioent)throws Exception{
Statement stmt  = conn.createStatement();
String sql2 = "SELECT `username`,`passw` FROM `Usuario` WHERE username = 'lucas22' AND passw = 'luuuuuucas'";
String sql = "SELECT `username`,`passw` FROM `Usuario`\n" +
" WHERE username = '"+usuarioent.getUsrname()+"'" +
"  AND passw = '"+usuarioent.getPassw()+"' ;";
            System.out.println(sql2);
            ResultSet rs = stmt.executeQuery(sql2);
             if (rs.next() == false) {
        System.out.println("Usuario no encontrado");
        return false;
      } else {
        return true;
        }
      }
            
            }
