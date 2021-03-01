package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    public void start() throws IOException, ClassNotFoundException
    {
        System.out.println("Starting server ...");

        try (
            ServerSocket serverSocket = new ServerSocket(1335)
            )
        {
            while(true)
            {
                Socket socket = serverSocket.accept();

                Thread thread = new Thread(new ServerSocketHandler(socket));
                thread.start();
            }
        }
    }
}
