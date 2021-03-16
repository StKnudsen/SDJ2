package server;

import shared.TextServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiTextServer implements TextServer
{
  public RmiTextServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void printTest(String text) throws RemoteException
  {
    System.out.println(text);
  }
}
