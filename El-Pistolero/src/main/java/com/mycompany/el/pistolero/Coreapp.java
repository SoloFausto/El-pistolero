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

import com.mycompany.el.pistolero.Pantalla;

import java.io.*;  
public class Coreapp {
        public static void main(String[] args) throws Exception{
Usuario[] usrs = new Usuario[10];
// Usuario(String Usrname,String email,String passw,String nombre)
Usuario usuario1 = new Usuario("Lucas","lucas@luacs.com","luucas1","Lucas T");
Usuario usuario2 = new Usuario("Lucas","lucas@luacs.com","luucas1","Lucas T");
            System.out.println(compararUsuarioLogin(usuario1,usuario2));

    
        }
        public static boolean compararUsuarioLogin(Usuario usr1,Usuario usr2){
            if(usr1.getPassw().equals(usr2.getPassw())&usr1.getUsrname().equals(usr2.getUsrname())){
                    return true;
            }
            else{
            return false;
            }

        }
  }