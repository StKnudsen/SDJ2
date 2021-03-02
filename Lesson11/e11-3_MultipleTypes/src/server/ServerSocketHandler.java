package server;

import transferobjects.Request;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Locale;

public class ServerSocketHandler implements Runnable
{
  private ConnectionPool connectionPool;
  private StringModel stringModel;
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private Socket socket;

  public ServerSocketHandler(Socket socket, ConnectionPool connectionPool, StringModel stringModel)
      throws IOException
  {
    this.connectionPool = connectionPool;
    this.stringModel = stringModel;
    this.socket = socket;

    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      System.out.println("Client connected from " + socket.getInetAddress().getHostAddress() + " " + socket.getLocalPort());

      while (true)
      {
        Request messageFromClient = ((Request) in.readObject());
        //Request.RequestType requestType = ((Request) in.readObject()).getRequestType();
        //System.out.println(requestType.name());

        if (messageFromClient.getArguments().equalsIgnoreCase("exit"))
        {
          connectionPool.removeHandler(this);
          break;
        }

        String message = "";
        switch (messageFromClient.getRequestType())
        {
          case LowerCase:
            message = stringModel.toLowerCase(messageFromClient.getArguments());
            //message = messageFromClient.getArguments().toLowerCase();
            break;
          case UpperCase:
            message = stringModel.toUpperCase(messageFromClient.getArguments());
            //message = messageFromClient.getArguments().toUpperCase();
            break;
        }
        connectionPool.broadcastMessage(message);
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
      out.writeObject(message);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

}
