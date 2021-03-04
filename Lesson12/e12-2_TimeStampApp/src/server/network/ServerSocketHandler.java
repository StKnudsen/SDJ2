package server.network;

import server.model.DataModel;
import shared.Request;

import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Date;

public class ServerSocketHandler implements Runnable
{
  private Socket socket;
  private DataModel dataModel;
  private ObjectInputStream input;
  private ObjectOutputStream output;

  public ServerSocketHandler(Socket socket, DataModel dataModel)
      throws IOException
  {
    this.socket = socket;
    this.dataModel = dataModel;

    input = new ObjectInputStream(socket.getInputStream());
    output = new ObjectOutputStream(socket.getOutputStream());
  }

  @Override public void run()
  {
    try
    {
      Request request = (Request) input.readObject();
      String requestType = request.getType();
      String result;

      switch (requestType)
      {
        case "getLastUpdateTimeStamp":
          result = dataModel.getLastUpdateTimeStamp();
          output.writeObject(new Request("getLastUpdateTimeStamp", result));
          break;
        case "getNumberOfUpdates":
          result = Integer.toString(dataModel.getNumberOfUpdates());
          output.writeObject(new Request("getNumberOfUpdates", result));
          break;
        case "setTimeStamp":
          dataModel.setTimeStamp(((Date) request.getArg()));
          break;
        case "Listener":
          dataModel.addPropertyChangeListener("updated", this::onUpdated);
          break;
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }

  }

  private void onUpdated(PropertyChangeEvent event)
  {
    try
    {
      output.writeObject(new Request(
          event.getPropertyName(),
          event.getNewValue()
      ));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
