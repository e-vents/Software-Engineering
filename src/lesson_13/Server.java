package lesson_13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try(ServerSocket listener = new ServerSocket(8080, 10, null)) {
			
			while(true) {
				try(Socket client = listener.accept();
					BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
					PrintWriter out = new PrintWriter(client.getOutputStream());
				) {
					String message = in.readLine();
					System.out.println("Received: " + message);
					String reply = "Hello from server!";
					out.write(reply + "\n");
					out.flush();
					System.out.println("Sent: " + reply);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception err) {
			System.out.println(err);
		}
	}
}
