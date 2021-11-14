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

// http://localhost:8080/registro?usuarios=fs&apellidos=ad&correo=dsaw%40dsa.com&nombre=rrr

public class Registro implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException{
    URI uri = exchange.getRequestURI();
    
String name = new File(uri.getPath()).getName();
    File path = new File("/Users/fausto/NetBeansProjects/El-pistolero/J", name);
    Headers h = exchange.getResponseHeaders();
    h.add("Content-Type", "*/*");
    OutputStream out = exchange.getResponseBody();
    String pass = "NULL";
//String usuario = "NULL";
if (path.exists()) {
      exchange.sendResponseHeaders(200, path.length());
      out.write(Files.readAllBytes(path.toPath()));
    } else {
      System.err.println("File not found: " + path.getAbsolutePath());

      exchange.sendResponseHeaders(200, path.length());
      out.write(Files.readAllBytes(path.toPath()));
    }
    
String query = exchange.getRequestURI().getQuery();


if(query.equals("usuarios=&apellidos=&correo=&nombre=")){
        out.close();

} 
else {
String [] keyValues = query.split("&");
String usuario = keyValues[0].split("=")[1];
String nombre = keyValues[1].split("=")[1];
String correo = keyValues[2].split("=")[1];
String contra = keyValues[3].split("=")[1];

Usuario usuarioent = new Usuario();
usuarioent.setUsrname(usuario);
usuarioent.setPassw(contra);
usuarioent.setEmail(correo);
usuarioent.setNombre(nombre);
        try {
            regUsuario(usuarioent);
        } catch (Exception ex) {
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