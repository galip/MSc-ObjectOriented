package homework2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Oct 8, 2016
 * 
 * @author galip
 *
 */
public class Server {

	public static void main(String args[]) throws IOException {
		
		SocketUtils socketUtils = new SocketUtils();
		StreamUtils streamUtils = new StreamUtils();
		
		Socket socket = socketUtils.createSocketOverServerSocket();
		
		ObjectInputStream objectInputStream = streamUtils.getObjectInputStream(socket);
		ObjectOutputStream objectOutputStream = streamUtils.getObjectOutputStream(socket);
		
		User user = (User) streamUtils.getObject(objectInputStream);

		user.setId(10);
		user.setName("Hagi");
		user.setMessage("Greetings from server side, machine 2.");
		
		streamUtils.writeObject(objectOutputStream, user);

		objectInputStream.close();
		objectOutputStream.close();

	}
}