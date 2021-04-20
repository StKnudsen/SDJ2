public class Start
{
  public static void main(String[] args)
  {
    ToiletBuilding resource = new ToiletBuilding();

    for (int i = 0; i < 10; i++)
    {
      Person person = new Person(resource, "person " + i);
      Thread t = new Thread(person);
      t.start();
    }

    for (int i = 0; i < 3; i++)
    {
      CleaningPerson cleaningPerson = new CleaningPerson(resource, "cleaner " + i);
      Thread t = new Thread(cleaningPerson);
      t.start();
    }
  }
}
