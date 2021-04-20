import java.util.ArrayList;

public class DBPersonStorage implements PersonStorage
{
  ArrayList<Person> people;

  public DBPersonStorage()
  {
    people = new ArrayList();
  }

  @Override public void addPerson(Person person)
  {
    people.add(person);
  }

  @Override public Person getPerson(int ssn)
  {
    for (Person person : people)
    {
      if (person.getSocialSecurityNumber() == ssn)
      {
        return person;
      }
    }

    return null;
  }
}