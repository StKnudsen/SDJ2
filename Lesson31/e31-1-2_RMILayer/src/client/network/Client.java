package client.network;

import shared.Person;
import shared.PropertyChangeSubject;

import java.util.List;

public interface Client extends PropertyChangeSubject
{
  List<Person> getPersons();
  void addPerson(Person person);
  void startClient();
}
