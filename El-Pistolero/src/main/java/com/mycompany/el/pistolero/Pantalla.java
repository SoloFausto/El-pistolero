package com.mycompany.el.pistolero;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Pantalla extends JFrame{
	JButton boton;
	JButton boton2;
	JLabel label1;
	Pantalla (int largo, int ancho) {
		label1 = new JLabel("bueno, esto funciona :DDDD");
		label1.setBounds(110,10,500,30);
		this.add(label1);
		
		this.setTitle("SaludarXD");
		
		this.boton = new JButton("Saludar");
		boton.setBounds(140, 65,100, 50);
		this.add(boton);
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
		this.boton2 = new JButton("Saludar2");
		boton2.setBounds(140, 150,100, 50);
		this.add(boton2);
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
	}
}