package client.network;

public class ClientFactory
{
  private static ClientFactory instance;

  static
  {
    instance = new ClientFactory();
  }

  public static ClientFactory getInstance()
  {
    return instance;
  }

  private Client client;

  public Client getClient()
  {
    if (client == null)
    {
      client = new RMIClientImpl();
    }
    return client;
  }
}
