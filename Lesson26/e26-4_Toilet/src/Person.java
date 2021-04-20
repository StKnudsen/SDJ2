public class Person implements Runnable
{
  private ToiletBuilding toiletBuilding;
  private String name;

  public Person(ToiletBuilding toiletBuilding, String name)
  {
    this.toiletBuilding = toiletBuilding;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      //toiletBuilding.stepIntoCabin();
      System.out.println(name + " \"I NEED TOO PEE!\" " + toiletBuilding.safeRead());
      //toiletBuilding.leaveCabin();

      try
      {
        Thread.sleep(200);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
