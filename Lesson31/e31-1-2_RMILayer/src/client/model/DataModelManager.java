package client.model;

import client.network.Client;
import shared.Person;
import shared.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class DataModelManager implements DataModel, PropertyChangeSubject
{
  private PropertyChangeSupport propertyChangeSupport;
  private Client client;

  public DataModelManager(Client client) {
    propertyChangeSupport = new PropertyChangeSupport(this);
    this.client = client;
    client.startClient();
    client.addPropertyChangeListener("updated",this::updated);
  }

  private void updated(PropertyChangeEvent propertyChangeEvent)
  {
    System.out.println("Clientens datamodelmanager blev kaldt juhuu");
    propertyChangeSupport.firePropertyChange(propertyChangeEvent);
  }

  @Override
  public List<Person> getPersons() {
    System.out.println("getPersons called at client");
    return client.getPersons();
  }

  @Override
  public void addPerson(Person person) {
    client.addPerson(person);
    System.out.println("addPerson called at client");
    propertyChangeSupport.firePropertyChange("updated", null, person);

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
