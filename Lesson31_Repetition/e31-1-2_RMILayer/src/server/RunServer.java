package server;

import server.network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RMIServerImpl server = new RMIServerImpl();
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Servernavnet", server);
    System.out.println("Den tekst du gerne vil skrive, når serveren er startet");
  }
}
