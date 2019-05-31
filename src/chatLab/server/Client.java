package chatLab.server;

import java.io.IOException;
import java.net.Socket;

public class Client {

	private Socket socket;
	private String name;
	
	protected Client(Socket socket) {
		this.socket = socket;
	}
	
	public void stop() {
		try {
			socket.close();
		} catch (IOException e) {
			
		}
	}
	@Override
	public String toString() {
		return name+": "+socket.toString();
	}
}
