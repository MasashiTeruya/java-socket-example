package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) throws IOException {
		try (Socket socket = new Socket("localhost", 52001)) {
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			printWriter.println("hello");
		}

	}

}
