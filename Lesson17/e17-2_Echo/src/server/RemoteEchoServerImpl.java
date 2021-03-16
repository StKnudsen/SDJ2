package server;

import shared.RemoteEchoServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteEchoServerImpl implements RemoteEchoServer
{
  public RemoteEchoServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUpperCase(String msg) {
    return msg.toUpperCase();
  }
}
