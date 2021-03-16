package client;

import shared.RemoteEchoServer;
import shared.Utils;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class EchoClient
{
  private RemoteEchoServer server;
  public EchoClient() {}

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", Utils.portNr);
    server = (RemoteEchoServer) registry.lookup(Utils.server);
  }

  public void addMessage(String msg) {
    try
    {
      System.out.println(server.toUpperCase(msg));
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
