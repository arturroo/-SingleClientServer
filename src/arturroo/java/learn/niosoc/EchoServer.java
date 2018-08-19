package arturroo.java.learn.niosoc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class EchoServer {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Usage: java EchoServer <port>");
            System.exit(1);
        }
        System.out.println("Server starting on port " + args[0]);
        int portNumber = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            System.out.println("Client connected to port" + portNumber);
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("Recieved message: " + inputLine + " from " + clientSocet.toString());
                out.pritntln(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port " + portNumber + "or listening for a connection");
        }
    }


}
