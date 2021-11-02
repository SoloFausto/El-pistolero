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
public class Coreapp {

        public static void main(String[] args) throws Exception{
 Socket clientSocket = new Socket("127.0.0.1", 6666);
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/elpistolero","root","root");
            System.out.println("###########SETUP TERMINADO, EMPEZANDO WHILE#############");
while(true){
Usuario usuarioent = new Usuario();
usuarioent.setUsrname(in.readLine());
usuarioent.setPassw(in.readLine());
usuarioent.setEmail(in.readLine());
usuarioent.setNombre(in.readLine());
String eleccion = in.readLine();
if(eleccion.equals("1")){
if(LogUsuario(conn,usuarioent)==false){
msj(out,"UsrNC");
}
else if (LogUsuario(conn,usuarioent)==true){
msj(out,"UsrSC");
}
}
else if (eleccion.equals("2")){
    System.out.println(RegUsuario(conn,usuarioent));
    System.out.println("RegUsuario");
}
            System.out.println("Eleccion="+eleccion);
 System.out.println("username: "+usuarioent.getUsrname());  
 System.out.println("passw: "+usuarioent.getPassw());
System.out.println("Email: "+usuarioent.getEmail());
System.out.println("nombre: "+usuarioent.getNombre());
}
        }
            public static String RegUsuario(Connection conn,Usuario regusuario)throws Exception{
Statement stmt  = conn.createStatement();
        String sql = "INSERT INTO `Usuario`(`username`, `email`, `passw`, `nombre`)" +
"VALUES ('"+regusuario.getUsrname()+"', '"+ regusuario.getEmail()+"', '"+ regusuario.getPassw()+"', '"+ regusuario.getNombre()+"');";
                       System.out.println(sql);
       stmt.execute(sql);
       return("Registracion completa!");
    }
        public static boolean LogUsuario(Connection conn, Usuario usuarioent)throws Exception{
Statement stmt  = conn.createStatement();
String sql = "SELECT `username`,`passw` FROM `Usuario`\n" +
" WHERE username = '"+usuarioent.getUsrname()+"'" +
"  AND passw = '"+usuarioent.getPassw()+"' ;";
            System.out.println(sql);
            ResultSet rs = stmt.executeQuery(sql);
             if (rs.next() == false) {
        System.out.println("Usuario no encontrado");
return false;
      } else {
                 System.out.println("Usuario Encontrado");
 return true;
        }
      }
                     static void msj(PrintWriter out,String str){
     out.println(str);
     }
  
}