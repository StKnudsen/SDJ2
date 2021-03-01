import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client
{
  public static void main(String[] args) throws IOException
  {
    Socket socket = new Socket("127.0.0.1", 1235);
    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
    BufferedReader in = new BufferedReader(
        new InputStreamReader(socket.getInputStream())
    );

    // Get response from Server
    String message = in.readLine();
    System.out.println(message);

    // Send calculation
    String calculation = new Scanner(System.in).nextLine();
    out.println(calculation);

    // Get result
    message = in.readLine();
    System.out.println(message);
  }
}
