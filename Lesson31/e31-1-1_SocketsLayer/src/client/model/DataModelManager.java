package client.model;

import client.network.Client;
import shared.Person;

import java.util.List;

public class DataModelManager implements DataModel
{
  private Client client;

  public DataModelManager(Client client) {
    this.client = client;
    client.startClient();
  }


  @Override
  public List<Person> getPersons() {
    return client.getPersons();
  }

  @Override
  public void addPerson(Person person) {
    client.addPerson(person);
  }
}
