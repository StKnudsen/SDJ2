package client;

import client.networking.SocketClient;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class RunClient extends Application
{
  public static void main(String[] args) throws IOException
  {
    //  Start client networking
    SocketClient socketClient = new SocketClient();
    socketClient.start();

    //  View

  }

  @Override public void start(Stage stage) throws Exception
  {

  }
}
