package com.mycompany.el.pistolero.Client;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.*;
public class Pantalla extends JFrame implements ActionListener{
	JButton boton;
	JLabel label1;
	String texto;
	String texto1;
	private JTextField campo1;
	private JTextField campo2;
	private JTextArea areaTexto1;
	Pantalla (int largo, int ancho) {
		
		this.setTitle("Titulo de ejemplo");
		
		this.setSize(largo, ancho);
		this.setLayout(null);
		
//text		
		campo1 = new JTextField();
		campo1.setBounds(110,50,150,30);
		this.add(campo1);
		texto1= campo1.getText();
		
		campo1.addActionListener(new ActionListener(){
			  public void actionPerformed (){

			  }

			@Override
			public void actionPerformed(ActionEvent e) {				
			}
			});
//text2		
		campo2 = new JTextField();
		campo2.setBounds(110,90,150,30);
		this.add(campo2);
		texto= campo2.getText();
		
		campo2.addActionListener(new ActionListener(){
			  public void actionPerformed (){

			  }

			@Override
			public void actionPerformed(ActionEvent e) {				
			}
			});
		
//AreaTexto1
		areaTexto1 = new JTextArea();
		areaTexto1.setBounds(110,200,150,30);
		areaTexto1.setColumns(2);
		this.add(areaTexto1);
		

//label
		label1 = new JLabel("pulsa entrar");
		label1.setBounds(150,170,500,30);
		this.add(label1);

//botón
		this.boton = new JButton("Entrar");
		boton.setBounds(135, 125,100, 50);
		this.add(boton);
		boton.addActionListener(new ActionListener (){
			public void actionPerformed (ActionEvent e) {
				areaTexto1.setText(campo1.getText() + " " + campo2.getText());
			}
			
		});

		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}