package server.network;

import server.model.DataModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  private DataModel dataModel;

  public SocketServer(DataModel dataModel)
  {
    this.dataModel = dataModel;
  }

  public void start()
  {
    System.out.println("Starting server .. hamsters are ready.. GO! ");

    try (
        ServerSocket serverSocket = new ServerSocket(2910);
        )
    {
      while (true)
      {
        Socket socket = serverSocket.accept();

        ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, dataModel);

        Thread thread = new Thread(serverSocketHandler);
        thread.start();
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
