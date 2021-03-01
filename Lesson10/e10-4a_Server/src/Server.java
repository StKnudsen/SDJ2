import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
  public static void main(String[] args)
  {
    System.out.println("Calculator Back to Basic v2");
    try (
        ServerSocket serverSocket = new ServerSocket(1235);
        )
    {
      while(true)
      {
        Socket socket = serverSocket.accept();
        System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // We have a connection
        out.println("*server* Give me a calculation formatted: int + - * int .. Like 1 + 1");


        // Get and calculate
        String calculationFromClient = in.readLine();
        String[] calculationArray = calculationFromClient.split(" ");
        int number1 = Integer.parseInt(calculationArray[0]);
        String operator = calculationArray[1];
        int number2 = Integer.parseInt(calculationArray[2]);

        int result = 0;
        switch (operator)
        {
          case "*":
            result = number1 * number2;
            break;
          case "+":
            result = number1 + number2;
            break;
          case "-":
            result = number1 - number2;
            break;
        }

        // Send result
        out.println("Result " + result);
      }

    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
