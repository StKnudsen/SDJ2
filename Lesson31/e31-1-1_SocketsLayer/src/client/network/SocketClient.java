package client.network;

import shared.Person;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class SocketClient implements Client
{
  List<Person> personList;

  public SocketClient()
  {
    personList = new ArrayList<>();
  }

  @Override public List<Person> getPersons()
  {
    return personList;
  }

  @Override public void addPerson(Person person)
  {
    personList.add(person);
  }

  @Override public void startClient()
  {
    System.out.println("Hallo hallo - start client");
  }

  @Override public void addPropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    //Observer pattern
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    //Observer pattern
  }

  @Override public void removePropertyChangeListener(String name,
      PropertyChangeListener listener)
  {
    //Observer pattern
  }

  @Override public void removePropertyChangeListener(
      PropertyChangeListener listener)
  {
    //Observer pattern
  }
}
