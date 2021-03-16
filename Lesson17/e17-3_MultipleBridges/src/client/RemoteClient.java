package client;

import shared.IStringChangingServer;
import shared.Utils;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteClient
{
  IStringChangingServer stringChangingServer;

  public RemoteClient() {}

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", Utils.PORT_NR);
    stringChangingServer = (IStringChangingServer) registry.lookup(Utils.SERVER);
  }

  public void changeToUpperCase(String arg) {
    try
    {
      System.out.println(stringChangingServer.getUpperCase().toUpperCase(arg));
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void changeToRandomCase(String arg) {
    try
    {
      System.out.println(stringChangingServer.getRandomCase().toRandomCase(arg));
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
