package server;

import java.io.IOException;

public class ServerMain
{
  public static void main(String[] args) throws IOException, ClassNotFoundException
  {
    Server server = new Server();
    server.start();
  }
}
