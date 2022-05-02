package ie.gmit.dip;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatServer {
	private static ServerSocket server;
	private static Socket client;
	private static BufferedReader in;
	private static PrintWriter out;
	private static Scanner scan = new Scanner(System.in);
	private static int PORT;
	private static String name;
	
	public static void main(String[] args) {
		startMenu(); // start application menu
		getName(); // call get name method to get users name for chat
		getPort(); // call get port method to get port number to connect to client
		scan = new Scanner(System.in); // re-initialise scan object
		
		try {
			server = new ServerSocket(PORT); // initialise server ServerSocket to listen on given port
			client = server.accept(); // initialise client Socket object to accept the server object
			out = new PrintWriter(client.getOutputStream()); // initialise PrintWriter out object
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); // initialise BufferedReader in object
			
			out.println("\n[INFO] You are connected to " + name);
			
			// thread for sender
			Thread send = new Thread(new Runnable() {
				String message; // contains the data written by the user
				
				@Override // override run method
				public void run() {
					while(true) {
						message = scan.nextLine(); // reads data from user
						// if statement to exit chat
						if(message.equalsIgnoreCase("\\q")) {
							try {
								out.println("\n[INFO] Chat ended.");
								out.flush();
								out.close();
								client.close();
								server.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
						}
						message = name + ": " + message;
						out.println("\n" + message + "\n"); // write data stored in message in the clientSocket
						out.flush(); // forces the sending of the data
					}
				}
			});
			send.start();
			
			// thread for receiver
			Thread receive = new Thread(new Runnable() {
				String message;
				
				@Override
				public void run() {
					try {
						message = in.readLine(); // read data from the clientSocket using the in object
						// while the client is still connected to the server
						while (message != null) {
							System.out.println(message); // print the message to the screen sent by client
							message = in.readLine(); // read data from the clientSocket using the in object
						}
						out.close();
						client.close();
						server.close();
					} catch (IOException e) {
						System.out.println("[INFO] Chat ended.");
					}
				}
			});
			receive.start();
		} catch (IOException e) {
			System.out.println("[INFO] Cannot connect.");
		}
		
	}

	// start menu heading for chat application
	private static void startMenu() {
		System.out.println("\n*******************************");
		System.out.println("*** Socket Chat Application ***");
		System.out.println("***   Network Tech - GMIT   ***");
		System.out.println("***      David Faulkner     ***");
		System.out.println("***        G00299507        ***");
		System.out.println("*******************************");
	}
	
	// ask the user to enter name
	private static void getName() {
		System.out.println("\n[INFO] Please enter your name: ");
		name = scan.nextLine();		
	}

	// ask the user to enter port for connection
	private static void getPort() {
		System.out.println("\n[INFO] Enter port number: ");
		PORT = scan.nextInt();
	}

}
