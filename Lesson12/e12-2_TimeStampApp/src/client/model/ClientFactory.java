package client.model;

import client.network.Client;
import client.network.SocketClient;

public class ClientFactory
{
  private static ClientFactory instance;

  static {
    instance = new ClientFactory();
  }

  public static ClientFactory getInstance()
  {
    return instance;
  }

  private Client client;

  public ClientFactory()
  {
  }

  public Client getClient()
  {
    if(client == null)
    {
      client = new SocketClient();
    }
    return client;
  }
}