package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{
    private ConnectionPool connectionPool = new ConnectionPool();
    private StringModel stringModel = new StringModel();

    public void start() throws IOException
    {
        System.out.println("Starting server ...");

        try (
            ServerSocket serverSocket = new ServerSocket(1335)
            )
        {
            while(true)
            {
                Socket socket = serverSocket.accept();

                ServerSocketHandler serverSocketHandler = new ServerSocketHandler(socket, connectionPool, stringModel);
                connectionPool.addHandler(serverSocketHandler);
                Thread thread = new Thread(serverSocketHandler);
                thread.start();
            }
        }
    }
}
