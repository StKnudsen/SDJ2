package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain
{
  public static void main(String[] args)
      throws RemoteException, NotBoundException
  {
    RemoteClient client = new RemoteClient();
    client.startClient();

    client.changeToRandomCase("Hello world!");
    client.changeToUpperCase("Hello world!");
  }
}
