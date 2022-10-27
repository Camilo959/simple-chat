import modelo.Despachador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);

        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();


                Despachador lector = new Despachador(clientSocket, "lector");
                lector.start();

                Despachador escritor = new Despachador(clientSocket, "escritor");
                escritor.start();

                //clientSocket.close();
            }

        } catch (Exception e) {
            System.out.println("Error>: " + e.getMessage());
        }
    }
}
