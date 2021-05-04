package client.network;

import shared.Person;
import shared.RMIServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClientImpl implements Client
{
  private PropertyChangeSupport propertyChangeSupport;
  private RMIServer server;

  public RMIClientImpl()
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  @Override public List<Person> getPersons()
  {
    try
    {
      return server.showButton();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void addPerson(Person person)
  {
    try
    {
      server.saveButton(person);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void startClient()
  {
    try
    {
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("Servernavnet");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      propertyChangeSupport.addPropertyChangeListener(listener);
    }
    else
    {
      propertyChangeSupport.addPropertyChangeListener(name, listener);
    }
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    if (name == null)
    {
      propertyChangeSupport.removePropertyChangeListener(listener);
    }
    else
    {
      propertyChangeSupport.removePropertyChangeListener(name, listener);
    }
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
}
