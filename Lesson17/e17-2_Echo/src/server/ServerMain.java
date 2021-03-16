package server;

import shared.RemoteEchoServer;
import shared.Utils;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    RemoteEchoServer server = new RemoteEchoServerImpl();
    Registry registry = LocateRegistry.createRegistry(Utils.portNr);
    registry.bind(Utils.server, server);

    System.out.println("Hamsters have started the TextServer ...");
  }
}
