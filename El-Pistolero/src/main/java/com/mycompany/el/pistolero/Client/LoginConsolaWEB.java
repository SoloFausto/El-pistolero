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
import java.net.http.HttpClient;
import java.util.Scanner;
import java.io.*;
import java.net.*;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
public class LoginConsolaWEB {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException{
        HttpClient.newBuilder(); 


        Scanner entrada = new Scanner (System.in);
        while (true){
            System.out.println("Bienvenido, que le gustaria hacer a continuacion?");
            System.out.println("1:Ingresar, 2:Registrarse");
            String eleccion = entrada.next();
                if(eleccion.equals("1")){
                    System.out.println("Nombre de usuario:");
                    String usuario = entrada.next();
                    System.out.println("Contraseña:");
                    String passw = entrada.next();
                    Usuario usuarioent = new Usuario();
                    usuarioent.setUsrname(usuario);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest requestlog = HttpRequest.newBuilder(
                    URI.create("http://localhost:8080/login?usr="+usuario+"&pass="+passw)) // Creamos una URI con los datos que le mandaremos al servidor
                    .version(HttpClient.Version.HTTP_2)
                    .GET()
                    .build();
                    HttpResponse<String> response = client //Le mandamos los datos al servidor
                    .send(requestlog, BodyHandlers.ofString());
                    String t = response.body();
                    System.out.println(t); // Imprimimos T que son los datos que nos devolvio el servidor.
                }
                else if (eleccion.equals("2")){
                    System.out.println("Nombre de usuario:");
                    String nombreusuarioscn = entrada.next();
                    System.out.println("Contraseña:");
                    String passw = entrada.next();
                    System.out.println("Email:");
                    String emailscn = entrada.next();
                    System.out.println("Nombre:");
                    String nombrescn = entrada.next();
                    System.out.println("Gracias!,volviendo a la pantalla de login.");
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest requestlog = HttpRequest.newBuilder(
                        URI.create("http://localhost:8080/registro?usuarios="+nombreusuarioscn+"&nombre="+nombrescn+"&correo="+emailscn+"&contra="+passw))
                        .version(HttpClient.Version.HTTP_2)
                        .GET()
                        .build();
                    HttpResponse<String> response = client
                        .send(requestlog, BodyHandlers.ofString());
                    System.out.println(response.body());    
                    }
                else{
                    System.out.println("Eleccion incorrecta,porfavor ingrese una opcion valida");
                }
        }
    }    
}
