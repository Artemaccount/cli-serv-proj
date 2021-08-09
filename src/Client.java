import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static final int PORT = 23444;
    public static final String HOST = "127.0.0.1";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, PORT);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             Scanner scanner = new Scanner(System.in)) {
                String msg;
                while (true) {
                    System.out.println("SERVER: " + in.readLine());
                    msg = scanner.nextLine();
                    out.println(msg);
                    if ("end".equals(msg)) break;
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
