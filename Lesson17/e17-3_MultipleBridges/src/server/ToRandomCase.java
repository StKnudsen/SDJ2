package server;

import shared.IToRandomCase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ToRandomCase implements IToRandomCase
{
  public ToRandomCase() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toRandomCase(String arg)
  {
    String result = "";

    char[] charArray = arg.toCharArray();

    for (int i = 0; i < charArray.length; i++)
    {
      result += Math.random() < 0.5 ? (charArray[i] + "").toUpperCase() : (charArray[i] + "").toLowerCase();
    }

    return result;
  }
}
