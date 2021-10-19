package com.mycompany.el.pistolero;
import javax.swing.*;
import java.awt.event.*;
public class Pantalla extends JFrame implements ActionListener{
	JButton boton;
	JLabel label1;
	private JTextField texto;
	
	Pantalla (int largo, int ancho) {
		
		this.setTitle("SaludarXD");
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		label1 = new JLabel("Login 100% serio");
		label1.setBounds(60,30,150,30);
		this.add(label1);
		
	    texto=new JTextField();
	    texto.setBounds(60,80,150,20);
	    add(texto);
		

		
		/*this.boton = new JButton("Saludar");
		boton.setBounds(140, 65,100, 50);
		this.add(boton);
		*/

		
	}
}