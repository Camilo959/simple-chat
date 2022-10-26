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

                while(true) { // acepta un cliente y luego acepta al otro (while).

                    Socket clientSocket = serverSocket.accept();
                    PrintWriter out =
                            new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(clientSocket.getInputStream()));

                    String inputLine;

                    while((inputLine = in.readLine()) != null) {
                        System.out.println(inputLine);
                        if(inputLine.equals("Bye.")) {
                            break;
                        }
                    }

                }

         } catch (Exception e) {
            System.out.println("");
        }
    }
}
