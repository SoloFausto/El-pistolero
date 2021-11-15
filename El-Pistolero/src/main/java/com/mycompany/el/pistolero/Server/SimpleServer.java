/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el.pistolero.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class SimpleServer extends WebSocketServer {

	public SimpleServer(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {

	}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("closed " + conn.getRemoteSocketAddress() + " with exit code " + code + " additional info: " + reason);
	}

	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("received message from "	+ conn.getRemoteSocketAddress() + ": " + message);
                System.out.println(message);
                String resting = Integer.toString(Login.re);
                System.out.println(resting);
                if(message.equals("PUTA")){
                    System.out.println("mandando resting");
                    conn.send(resting);
                    
                }
	}

	@Override
	public void onMessage( WebSocket conn, ByteBuffer message ) {
		System.out.println("received ByteBuffer from "	+ conn.getRemoteSocketAddress());

	}
	@Override
	public void onError(WebSocket conn, Exception ex) {
		System.err.println("an error occurred on connection " + conn.getRemoteSocketAddress()  + ":" + ex);
	}
	
	@Override
	public void onStart() {
		System.out.println("server started successfully");
	}


	public static void main(String[] args) {
		String host = "localhost";
		int port = 8887;
		WebSocketServer server = new SimpleServer(new InetSocketAddress(host, port));
                server.run();
	}
}