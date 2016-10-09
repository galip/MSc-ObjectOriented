package homework2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Oct 8, 2016
 * @author galip
 *
 */
public class StreamUtils {
	
	public ObjectOutputStream getObjectOutputStream(Socket socket) {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectOutputStream;
	}

	public ObjectInputStream getObjectInputStream(Socket socket) {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return objectInputStream;
	}
	
	public Object getObject(ObjectInputStream objectInputStream) {
		try {
			return objectInputStream.readObject();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Object writeObject(ObjectOutputStream objectOutputStream, Object object) {
		try {
			objectOutputStream.writeObject(object);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}