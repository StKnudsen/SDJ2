package client.networking;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketClient
{
    private ClientSocketHandler clientSocketHandler;
    //private Thread thread;

    /*
    public Client()
    {

    }

     */

    public void start() throws IOException {
        try (
            Socket socket = new Socket("127.0.0.1", 1335)
            )
        {
            this.clientSocketHandler = new ClientSocketHandler(this, socket);
            Thread thread = new Thread(clientSocketHandler);
            thread.setDaemon(true);
            thread.start();
            //Message message = (Message)in.readObject();
            //System.out.println(message.getText());
            while (true)
            {
                String messageFromClient = new Scanner(System.in).nextLine();
                clientSocketHandler.sendMessage(messageFromClient);
                if (messageFromClient.equalsIgnoreCase("exit"))
                {
                    break;
                }
            }
        }
    }

    public void messageReceived(String message)
    {
        System.out.println(message);
    }
}
