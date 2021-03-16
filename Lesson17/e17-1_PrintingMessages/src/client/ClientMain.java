package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientMain
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    TextClient client = new TextClient();
    client.startClient();

    Scanner in = new Scanner(System.in);

    while (true)
    {
      System.out.print("Enter text: ");
      String text = in.nextLine();

      if (text.equals("exit")) {
        break;
      }

      client.sendText(text);
    }
  }
}
