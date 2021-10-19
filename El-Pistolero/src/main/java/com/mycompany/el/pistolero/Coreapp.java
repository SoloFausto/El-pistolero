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
public class Coreapp {
        public static void main(String[] args) throws Exception{
    String file = ("Usuarios.txt");
    String Usrname = "Usuario12";
    String email = "fausto@fausto.com";
    String passw = "1234";
    String nombre = "Fausto";
    Usuario[] usuarios = new Usuario[10];
    Usuario.crearUsuario(Usrname, email, passw, nombre, file);
        }
  }