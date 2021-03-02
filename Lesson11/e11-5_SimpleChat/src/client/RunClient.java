package client;

import client.networking.SocketClient;

import java.io.IOException;

public class RunClient
{
  public static void main(String[] args) throws IOException
  {
    SocketClient socketClient = new SocketClient();
    socketClient.start();
  }
}
