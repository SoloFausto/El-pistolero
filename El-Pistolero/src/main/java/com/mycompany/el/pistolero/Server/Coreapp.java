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
            
            ServerSocket serverSocket = new ServerSocket(6666);
Socket clientSocket = serverSocket.accept();
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.println("Terminado el setup");
Usuario[] usrs = new Usuario[0];
//Usuario usuario2 = new Usuario("Lucas11","lucas@luacs.com","luucas1","Lucas T");
while(true){
Usuario usuarioent = new Usuario();
usuarioent.setUsrname(in.readLine());
usuarioent.setPassw(in.readLine());
usuarioent.setEmail(in.readLine());
usuarioent.setNombre(in.readLine());
String eleccion = in.readLine();
if(eleccion.equals("1")){
    for(int i=0; i<=usrs.length; i++){
if(compararUsuario(usrs[i],usuarioent)==true){
msj(out,"OK");
    System.out.println("Login coorecto");
break;
}
else{
    msj(out,"NO");
    System.out.println("AAAAAAAAAAAAAAA");
}
}
}
else if (eleccion.equals("2")){
    RegUsuario(usrs,usuarioent);
    System.out.println("Registriando usuario");

}
            System.out.println("Eleccion="+eleccion);
    System.out.println("Usrs.lengthe="+usrs.length);
 System.out.println("username: "+usuarioent.getUsrname());  
 System.out.println("passw: "+usuarioent.getPassw());
System.out.println("Email: "+usuarioent.getEmail());
System.out.println("nombre: "+usuarioent.getNombre());
}
        }
        public static boolean compararUsuario(Usuario usr1,Usuario usr2){
            if(usr1.getPassw().equals(usr2.getPassw())&usr1.getUsrname().equals(usr2.getUsrname())){
                    return true;
            }
            else{
            return false;
            }
            
        }
        
            public static Usuario[] RegUsuario(Usuario arr[], Usuario usuarioreg)
    {
        int i;
        Usuario newarr[] = new Usuario[arr.length+ 1];
        for (i = 0; i < arr.length; i++)
            newarr[i] = arr[i];
  
        newarr[newarr.length-1] = usuarioreg;
  
        return newarr;
    }
            public static void LogUsuario(Usuario Usuarioent){
            
            //return login;
            }
                     static void msj(PrintWriter out,String str){
     out.println(str);
     }
  
}