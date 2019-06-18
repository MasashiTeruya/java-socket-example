package server;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String args[]) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(52001)) {
			System.out.println("MyServer is running at" + serverSocket.getLocalPort());
			while (true) {
				try (Socket socket = serverSocket.accept()) {
					InputStream inputStream = socket.getInputStream();
					byte[] inputBuffer = new byte[255];
					inputStream.read(inputBuffer);
					String inputText = new String(inputBuffer);
					System.out.println("Received Message: " + inputText);

					PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
					printWriter.println();
				}
			}
		}
	}
}
