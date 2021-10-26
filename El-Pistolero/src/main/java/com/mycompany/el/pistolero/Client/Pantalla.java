package com.mycompany.el.pistolero.Client;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.*;
public class Pantalla extends JFrame implements ActionListener{
	JButton boton;
	JLabel label1;
	String texto;
	private JTextField campo1;
	Pantalla (int largo, int ancho) {
		
		this.setTitle("Titulo de ejemplo");
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
//text		
		campo1 = new JTextField();
		campo1.setBounds(110,50,150,30);
		this.add(campo1);
		texto= campo1.getText();
		
		campo1.addActionListener(new ActionListener(){
			  public void actionPerformed (){

			  }

			@Override
			public void actionPerformed(ActionEvent e) {				
			}
			});
//text
//label
		label1 = new JLabel("pulsa entrar");
		label1.setBounds(150,150,500,30);
		this.add(label1);
//label
//botón
		this.boton = new JButton("Entrar");
		boton.setBounds(135, 100,100, 50);
		this.add(boton);
//botón

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}