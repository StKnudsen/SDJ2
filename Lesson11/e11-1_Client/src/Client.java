import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client
{

    public void start() throws IOException {
        try (
            Socket socket = new Socket("127.0.0.1", 1335);
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in =  new ObjectInputStream(socket.getInputStream());
            )
        {
            Message message = (Message)in.readObject();
            System.out.println(message.getText());
            String name = new Scanner(System.in).nextLine();
            out.writeObject(new Message(name));
            message = (Message) in.readObject();
            System.out.println(message.getText());
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
