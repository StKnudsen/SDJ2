package server;

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
    StringChangingServer server = new StringChangingServer();
    Registry registry = LocateRegistry.createRegistry(Utils.PORT_NR);
    registry.bind(Utils.SERVER, server);

    System.out.println(
        "The hamsters have been working hard and the server is now ready!");
  }
}
