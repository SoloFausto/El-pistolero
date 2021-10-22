package com.mycompany.el.pistolero.Client;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
public class Pantalla extends JFrame{
	JButton boton;
	JLabel label1;
	String texto;
	private JTextField campo1;
	Pantalla (int largo, int ancho) {
		
		this.setTitle("Titulo de ejemplo");
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
		campo1 = new JTextField();
		campo1.setBounds(110,50,150,30);
		this.add(campo1);
		texto= campo1.getText();
//text
		label1 = new JLabel(texto);
		label1.setBounds(110,10,500,30);
		this.add(label1);
//label
		this.boton = new JButton("Saludar");
		boton.setBounds(140, 65,100, 50);
		this.add(boton);
//botón

		
	}
}