package server;

import transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private ConnectionPool connectionPool;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private Socket socket;

  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool)
      throws IOException
  {
    this.socket = socket;
    this.connectionPool = connectionPool;

    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());
      //out.writeObject(new Message("Hello from server. Write your name"));
      while (true)
      {
        String messageFromClient = ((Message) in.readObject()).getText();

        if (messageFromClient.equalsIgnoreCase("exit"))
        {
          connectionPool.remove(this);
          break;
        }
        connectionPool.broadcastMessage(messageFromClient);
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  public void sendMessage(String message)
  {
    try
    {
      out.writeObject(new Message(message));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
