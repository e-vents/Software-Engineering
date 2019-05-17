package lesson_13;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
	
	public static void main(String[] args) {
	    //try/catch enclosed with curved braces for classes which implements autocolseable
	    try (Socket s = new Socket("127.0.0.1", 8080);
	    		OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
	    		//BufferedReader is more confortable
	    		BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
	    	) {
	    	//sends request
	    	out.write("Hello from client!\n");
	    	out.flush();
	    	
			System.out.println(in.readLine());
	        	
	    } catch (Exception e) {
	        
	    }
	    //no need of a finally statement that closed all the resources
	}
}

