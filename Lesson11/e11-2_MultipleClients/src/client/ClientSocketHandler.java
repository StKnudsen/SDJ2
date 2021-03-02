package client;

import transferobjects.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientSocketHandler implements Runnable
{
  private ObjectOutputStream out;
  private ObjectInputStream in;
  private Client client;
  //private Socket socket;

  public ClientSocketHandler(Client client, Socket socket) throws IOException
  {
    this.client = client;
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
        client.messageReceived(message.getText());
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
