package lesson_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket listener = new ServerSocket(8080, 10, null)) {
			// loops till program is closed --> daemon 
			while(true) {
				
				try(Socket client = listener.accept();
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter out = new PrintWriter(client.getOutputStream());
				) {
					//receives client request
					System.out.println("Received: " + in.readLine());
					
					//sends an answer
					out.write("Hello from server!\n");
					out.flush();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception err) {
			System.out.println(err);
		}
	}
}
