package com.mycompany.el.pistolero.Client;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;
public class Pantalla extends JFrame{
	JButton boton;
	JLabel label1;
	Pantalla (int largo, int ancho) {
		
		this.setTitle("SaludarXD");
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
		
		label1 = new JLabel("Login test");
		label1.setBounds(110,10,500,30);
		this.add(label1);
//label
		this.boton = new JButton("Saludar");
		boton.setBounds(140, 65,100, 50);
		this.add(boton);
//botón

		
	}
}