package server;

import shared.IStringChangingServer;
import shared.IToRandomCase;
import shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class StringChangingServer implements IStringChangingServer
{
  public StringChangingServer() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public IToUpperCase getUpperCase() throws RemoteException
  {
    return new ToUpperCase();
  }

  @Override public IToRandomCase getRandomCase() throws RemoteException
  {
    return new ToRandomCase();
  }
}
