package server;

import server.model.DataModelManager;
import server.network.SocketServer;

public class RunServer
{
  public static void main(String[] args) {
    SocketServer server = new SocketServer(new DataModelManager());
    server.start();
  }
}
