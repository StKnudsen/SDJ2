package server;

import shared.TextServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    TextServer server = new RmiTextServer();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("TextServer", server);

    System.out.println("Hamsters have started the TextServer ...");
  }
}
