package homework2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Oct 8, 2016
 * 
 * @author galip
 *
 */
public class Client {
	public static void main(String args[]) {

		SocketUtils socketUtils = new SocketUtils();
		StreamUtils streamUtils = new StreamUtils();
		Socket socket = null;
		
		socket = socketUtils.openSocket();

		// create new User object
		User user = new User();
		user.setId(1905);
		user.setName("Galip");
		user.setMessage("Greetings from client side, machine 1.");

		System.out.println(user.toString());
		
		//serialize user object
		if(socket != null) {
			ObjectOutputStream objectOutputStream = streamUtils.getObjectOutputStream(socket);
			streamUtils.writeObject(objectOutputStream, user);
		}
		
		//user instance gets data from server side, machine 2
		if(socket != null) {
			ObjectInputStream objectInputStream = streamUtils.getObjectInputStream(socket);
			user = (User) streamUtils.getObject(objectInputStream);
		}

		System.out.println(user.toString());

	}
}