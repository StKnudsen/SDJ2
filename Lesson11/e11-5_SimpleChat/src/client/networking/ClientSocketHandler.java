package client.networking;

import transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private SocketClient socketClient;
  //private Socket socket;

  public ClientSocketHandler(SocketClient socketClient, Socket socket) throws IOException
  {
    this.socketClient = socketClient;
    //this.socket = socket;

    out = new ObjectOutputStream(socket.getOutputStream());
    in =  new ObjectInputStream(socket.getInputStream());
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        Message message = (Message) in.readObject();
        socketClient.messageReceived(message.getText());
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
      System.out.println("Sending message: " + message);
      out.writeObject(new Message(message));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
