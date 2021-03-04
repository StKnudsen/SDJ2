package client.network;

import shared.Request;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class SocketClient implements Client
{
  PropertyChangeSupport support;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
  }

  @Override public void addPropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void addPropertyChangeListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }

  @Override public void removePropertyChangeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

  @Override public String getLastUpdateTimeStamp()
  {
    try {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeObject(new Request("getLastUpdateTimeStamp", null));
      Request response = (Request) inFromServer.readObject();
      return (String) response.getArg();
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override public int getNumberOfUpdates()
  {
    try {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      outToServer.writeObject(new Request("getNumberOfUpdates", null));
      Request response = (Request) inFromServer.readObject();
      return Integer.parseInt((String) response.getArg());
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }

    return 0;
  }

  @Override public void setTimeStamp(Date timeStamp)
  {
    try {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());

      outToServer.writeObject(new Request("setTimeStamp", timeStamp));

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override public void startClient()
  {
    try {
      Socket socket = new Socket("localhost", 2910);
      ObjectOutputStream outToServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream inFromServer = new ObjectInputStream(socket.getInputStream());

      Thread thread = new Thread(() -> listenToServer(outToServer, inFromServer));
      thread.start();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void listenToServer(ObjectOutputStream outToServer, ObjectInputStream inFromServer)
  {
    try {
      outToServer.writeObject(new Request("Listener", null));

      while (true) {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.getType(), null, request.getArg());
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }
}
