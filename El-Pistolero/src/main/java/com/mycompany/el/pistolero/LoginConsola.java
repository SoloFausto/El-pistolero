/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero;

/**
 *
 * @author fausto
 */
        import java.util.Scanner;
import java.io.*;  
public class LoginConsola {
    public static void main(String[] args){
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
