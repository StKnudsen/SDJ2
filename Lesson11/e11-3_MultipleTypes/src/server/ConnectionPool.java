package server;

import transferobjects.Request;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> connections;

  public ConnectionPool()
  {
    connections = new ArrayList<>();
  }

  public void addHandler(ServerSocketHandler serverSocketHandler)
  {
    connections.add(serverSocketHandler);
  }

  public void removeHandler(ServerSocketHandler serverSocketHandler)
  {
    connections.remove(serverSocketHandler);
  }

  public void broadcastMessage(String message)
  {
    for (ServerSocketHandler serverSocketHandler: connections)
    {
      serverSocketHandler.sendMessage(message);
    }
  }
}
