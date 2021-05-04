package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  void saveButton(Person person) throws RemoteException;
  List<Person> showButton() throws RemoteException;
}
