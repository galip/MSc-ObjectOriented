package homework2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Oct 8, 2016
 * 
 * @author galip
 *
 */
public class Client {
	public static void main(String args[]) {

		Socket socket = null;
		// create a new sockect
		try {
			socket = new Socket("localhost", 4443);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// create new User object
		User user = new User();
		user.setId(1905);
		user.setName("Galip");
		user.setMessage("Greetings from Client, machine 1");

		System.out.println(toString(user));

		try {
			objectOutputStream.writeObject(user);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// user instance reads object from server side, machine 2
		try {
			user = (User) objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println(toString(user));

	}

	/**
	 * @param user
	 * @return
	 */
	private static String toString(User user) {
		return "id : " + user.getId() + " name : " + user.getName() + " message: "
				+ user.getMessage();
	}
}