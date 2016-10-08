package homework2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Oct 8, 2016
 * @author galip
 *
 */
public class Server {
	
	private static final int PORT = 4444;
	
	public static void main (String args[]) throws IOException {
		
		User user = new User();
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Socket socket = null;
		try {
			socket = serverSocket.accept();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			user = (User) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setId(1);
		user.setName("Mehmet");
		user.setMessage("Greetings from Server side, machine 2.");
		
		try {
			objectOutputStream.writeObject(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		objectInputStream.close();
		objectOutputStream.close();
		
	}
}
