/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Client;

/**
 *
 * @author fausto
 */
import com.mycompany.el.pistolero.Server.Usuario;
    
        import java.util.Scanner;
import java.io.*;
import java.net.*;
public class LoginConsola {
    public static void main(String[] args) throws IOException{
        Socket clientSocket = new Socket("127.0.0.1", 6666);
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

Scanner entrada = new Scanner (System.in);
        System.out.println("Bienvenido, que le gustaria hacer a continuacion?");
        System.out.println("1:Ingresar, 2:Registrarse");
        
        int eleccion = entrada.nextInt();
        
        if(eleccion == 1){
        Usuario usuariolog = new Usuario();
        System.out.println("Nombre de usuario:");
            String nombreusuarioscn = entrada.next();
                usuariolog.setUsrname(nombreusuarioscn);
        System.out.println("Contraseña:");
            String passw = entrada.next();
                usuariolog.setPassw(passw);
        }
        else if (eleccion == 2){
        Usuario usuarioreg = new Usuario();
        System.out.println("Nombre de usuario:");
            String nombreusuarioscn = entrada.next();
              usuarioreg.setUsrname(nombreusuarioscn);
        System.out.println("Email:");
            String emailscn = entrada.next();
                usuarioreg.setEmail(emailscn);
        System.out.println("Nombre:");
            String nombrescn = entrada.next();
                usuarioreg.setNombre(nombrescn);
        System.out.println("Contraseña:");
            String passw = entrada.next();
                usuarioreg.setPassw(passw);
                
        }
    
    }
    
}
