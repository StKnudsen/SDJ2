package server.model;

import shared.Person;
import shared.PropertyChangeSubject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DataModelManager implements DataModel, PropertyChangeSubject
{
  private PropertyChangeSupport support;

  private List<Person> persons = new ArrayList<>();
  private PropertyChangeSupport propertyChangeSupport;

  public DataModelManager() {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  @Override
  public List<Person> getPersons() {
    System.out.println("getPersons called at server");
    return persons;
  }

  @Override
  public void addPerson(Person person) {
    System.out.println("addPerson called at server");
    persons.add(person);
    propertyChangeSupport.firePropertyChange("PersonAdded", null, person);
  }

  @Override
  public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(name, listener);
  }

  @Override
  public void addPropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override
  public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(name, listener);
  }

  @Override
  public void removePropertyChangeListener(PropertyChangeListener listener) {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }
}
