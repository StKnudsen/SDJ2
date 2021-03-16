package client;

import shared.TextServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class TextClient
{
  private TextServer server;

  public TextClient() {}

  public void startClient() throws RemoteException, NotBoundException {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (TextServer) registry.lookup("TextServer");
  }

  public void sendText(String text) {
    try
    {
      server.printTest(text);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
