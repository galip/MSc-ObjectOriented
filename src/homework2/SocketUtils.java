package homework2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Oct 8, 2016
 * 
 * @author galip
 *
 */
public class SocketUtils {

	private static final int PORT = 4444;

	public Socket openSocket() {
		try {
			return new Socket("localhost", PORT);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ServerSocket openServerSocket() {
		try {
			return new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Socket createSocketOverServerSocket() {
		System.out.println("Creating server socket...");
		ServerSocket serverSocket = openServerSocket();
		try {
			return serverSocket.accept();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}