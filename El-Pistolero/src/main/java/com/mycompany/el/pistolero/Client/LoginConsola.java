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
    public static void main(String[] args) throws IOException, InterruptedException{
           ServerSocket serverSocket = new ServerSocket(6666);
       Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Scanner entrada = new Scanner (System.in);
while (true){
                    System.out.println("Bienvenido, que le gustaria hacer a continuacion?");
                    System.out.println("1:Ingresar, 2:Registrarse");
                            String eleccion = entrada.next();
                    if(eleccion.equals("1")){
                        pantlog(out,in,entrada);
                    }
                    else if (eleccion.equals("2")){
                    pantreg(entrada,out);
                    }
                    else{System.out.println("Eleccion incorrecta,porfavor ingrese una opcion valida");}
}
    
}

     void pantlog(PrintWriter out,BufferedReader in,Scanner entrada) throws IOException, InterruptedException{
        String eleccion = "1";
            System.out.println("Nombre de usuario:");
            String nombreusuarioscn = entrada.next();
                msj(out,nombreusuarioscn);
        System.out.println("Contraseña:");
            String passw = entrada.next();
                msj(out,passw);
                msj(out,"N/A");
                msj(out,"N/A");
                msj(out,eleccion);
                String resultado = in.readLine();
                System.out.println(resultado);
                int esperar = 10000;
                int intentos = 0;
                if(resultado.equals("UsrNC")){

                    System.out.println("Nombre de usuario o contraseña incorrecta");
                    intentos++;
                    System.out.println("numint "+intentos);
                    System.out.println("segundos a esperar"+esperar);
                    if(intentos % 3 == 0){
                        System.out.println("Intentaste entrar muchas veces,por favor espera "+ esperar+" segundos");
                        System.out.println("numint "+intentos);
                        Thread.sleep(esperar);
                       int newsperar = esperar + 10000;
                       esperar = newsperar;
                       System.out.println("segundos a esperar"+esperar);
                    }
                }
                else if (resultado.equals("UsrSC")){
                    System.out.println("Bienvenido!");
                    intentos = 0;
                    esperar = 10000;

                }
    
    }
    static void pantreg(Scanner entrada, PrintWriter out){
           System.out.println("Nombre de usuario:");
            String nombreusuarioscn = entrada.next();
            msj(out,nombreusuarioscn);
        System.out.println("Contraseña:");
            String passw = entrada.next();
            msj(out,passw);
        System.out.println("Email:");
            String emailscn = entrada.next();
            msj(out,emailscn);
        System.out.println("Nombre:");
            String nombrescn = entrada.next();
            msj(out,nombrescn);
            System.out.println("Gracias!,volviendo a la pantalla de login.");
    }
         static void msj(PrintWriter out,String str){
     out.println(str);
     }
    
}
