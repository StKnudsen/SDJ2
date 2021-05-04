package server.network;

import server.model.DataModelManager;
import shared.Person;
import shared.RMIServer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIServerImpl implements RMIServer
{
  DataModelManager modelManager;
  PropertyChangeSupport propertyChangeSupport;

  public RMIServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    modelManager = new DataModelManager();
    modelManager.addPropertyChangeListener("PersonAdded", this::updated);
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  private void updated(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("Update blev kaldt juhuu");
    propertyChangeSupport.firePropertyChange("updated",propertyChangeEvent.getOldValue(),propertyChangeEvent.getNewValue());
  }

  @Override public void saveButton(Person person) throws RemoteException
  {
    modelManager.addPerson(person);
  }

  @Override public List<Person> showButton() throws RemoteException
  {
    return modelManager.getPersons();
  }
}
