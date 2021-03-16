package server;

import shared.IToUpperCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToUpperCase implements IToUpperCase
{
  public ToUpperCase() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUpperCase(String arg)
  {
    return arg.toUpperCase();
  }
}
