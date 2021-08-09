import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(Client.PORT)) {
            System.out.println("Server started!");
            Socket client = server.accept();
            System.out.print("Connection accepted");
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out.println("Enter your integer for me or `end` for exit: ");
            while (true) {
                String input = in.readLine();
                if ((input.equals("end"))) break;
                if (isDigit(input)) {
                    // представим здесь очень сложное вычисление ._.
                    out.println(Integer.toBinaryString(Integer.parseInt(input)) + ". Enter new integer: ");
                } else {
                    out.println(input + " not a number:( Enter new integer: ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
