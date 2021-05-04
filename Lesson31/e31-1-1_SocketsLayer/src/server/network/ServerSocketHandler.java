package server.network;

import server.model.DataModel;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private DataModel dataModel;
  private ObjectInputStream input;
  private ObjectOutputStream output;

  public ServerSocketHandler(Socket socket, DataModel dataModel)
      throws IOException
  {
    this.socket = socket;
    this.dataModel = dataModel;

    output = new ObjectOutputStream(socket.getOutputStream());
    input = new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      //TODO: en masse sjovt request-gejl
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
