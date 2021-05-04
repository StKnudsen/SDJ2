package server.network;

import server.model.DataModel;
import server.model.DataModelManager;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer
{
  DataModel dataModel;

  public SocketServer(DataModelManager dataModel)
  {
    this.dataModel = dataModel;
  }

  public void start()
  {
    System.out.println("Starting server ...");

    try (ServerSocket serverSocket = new ServerSocket(2910))
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
