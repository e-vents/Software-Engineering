package lesson_13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
	        
	    try (Socket s = new Socket("127.0.0.1", 8080);
	    		OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
	    		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    	) {
	    	
	    	String message = "Hello from client!";
	    	out.write(message + "\n");
	    	out.flush();
	    	
	    	String reply = in.readLine();
			System.out.println("Received: " + reply);
	        	
	    } catch (Exception e) {
	        	
	    }
	}
}

