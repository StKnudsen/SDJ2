package client.model;

import shared.Person;

import java.util.List;

public interface DataModel
{
  List<Person> getPersons();
  void addPerson(Person person);
}
