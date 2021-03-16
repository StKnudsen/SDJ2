package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextServer extends Remote {
    void printTest(String text) throws RemoteException;
}
