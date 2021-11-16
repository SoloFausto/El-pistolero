package com.mycompany.el.pistolero.Server;
import com.sun.net.httpserver.*;
import java.net.*;
import java.sql.*;
import java.io.*;  
import com.sun.net.httpserver.HttpServer;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fausto
 */



public class Registro implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
        OutputStream out = exchange.getResponseBody();
        String query = exchange.getRequestURI().getQuery();
        if(query.equals("usuarios=&apellidos=&correo=&nombre=")){ // Si la URI no tiene datos de login, la ignoramos
            out.close();
        } 
        else {
            String [] keyValues = query.split("&");
            String usuario = keyValues[0].split("=")[1];
            String nombre = keyValues[1].split("=")[1];  // Separamos la URI en 4 valores distintos
            String correo = keyValues[2].split("=")[1];
            String contra = keyValues[3].split("=")[1];
            Usuario usuarioent = new Usuario();
            usuarioent.setUsrname(usuario);
            usuarioent.setPassw(contra);
            usuarioent.setEmail(correo);
            usuarioent.setNombre(nombre);  // Creamos una nueva instancia Usuario y le llenamos los valores
            try {
                regUsuario(usuarioent);       // Llamamos al metodo regUsuario para registrar al usuario
                String verdadera = "Usuario registrado!";
                byte[] respuesta = verdadera.getBytes();
                exchange.sendResponseHeaders(200, respuesta.length);
                out.write(respuesta);
            }
            catch (Exception ex) {      // Si no se puede, mandamos un mensaje de error
                String verdadera = "Se ha producido un error.";
                byte[] respuesta = verdadera.getBytes();
                exchange.sendResponseHeaders(200, respuesta.length);
                out.write(respuesta);
                Logger.getLogger(Registro.class.getName()).log(Level.SEVERE, null, ex);
            }   
        }
    }
    public static void regUsuario(Usuario regusuario)throws Exception{
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:8889/elpistolero","root","root");
        Statement stmt  = conn.createStatement();
        String sql = "INSERT INTO `Usuario`(`username`, `email`, `passw`, `nombre`)" +
        "VALUES ('"+regusuario.getUsrname()+"', '"+ regusuario.getEmail()+"', '"+ regusuario.getPassw()+"', '"+ regusuario.getNombre()+"');";
        System.out.println(sql);
        stmt.execute(sql);
    }
}