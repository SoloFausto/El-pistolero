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

import java.io.*;  
public class Coreapp {
        public static void main(String[] args) throws Exception{
            ServerSocket serverSocket = new ServerSocket(6666);
Socket clientSocket = serverSocket.accept();
PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("Terminado la parte de sockets");
//Usuario[] usrs = new Usuario[10];
// Usuario(String Usrname,String email,String passw,String nombre)
Usuario usuario1 = new Usuario("lucas","a","lucas@luacs.com","Lucas T");
Usuario usuario2 = new Usuario("lucas\n","a\n","lucas@luacs.com","Lucas T");
//Usuario usuario2 = new Usuario("Lucas11","lucas@luacs.com","luucas1","Lucas T");

Usuario usuarioent = new Usuario();
usuarioent.setUsrname(in.readLine());
usuarioent.setPassw(in.readLine());
if(in.readLine().equals("a0")){
usuarioent.setEmail("N/A");
usuarioent.setNombre("N/A");
} else {
usuarioent.setEmail(in.readLine());
usuarioent.setNombre(in.readLine());
}
            System.out.println("Email: "+usuarioent.getEmail());
            System.out.println("passw: "+usuarioent.getPassw());
            System.out.println("nombre: "+usuarioent.getNombre());
            System.out.println("username: "+usuarioent.getUsrname());
            System.out.println(compararUsuario(usuario1,usuarioent));
        }
        public static boolean compararUsuario(Usuario usr1,Usuario usr2){
            if(usr1.getPassw().equals(usr2.getPassw())&usr1.getUsrname().equals(usr2.getUsrname())){
                    return true;
            }
            else{
            return false;
            }
            
        }
}