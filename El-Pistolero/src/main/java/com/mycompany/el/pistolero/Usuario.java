/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero;

/**
 *
 * @author fausto
 */
public class Usuario {
    String Usrname;
    String email;
    String passw;
    String nombre;
    Usuario(){}
Usuario(String Usrname,String email,String passw,String nombre){
            this.Usrname = Usrname;
            this.email = email;
            this.nombre = nombre;
            this.passw = passw;
        }
    public String getUsrname() {
        return Usrname;
    }

    public void setUsrname(String Usrname) {
        this.Usrname = Usrname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
