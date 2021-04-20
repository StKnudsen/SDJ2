public class CleaningPerson implements Runnable
{
  private ToiletBuilding toiletBuilding;
  private String name;

  public CleaningPerson(ToiletBuilding toiletBuilding, String name)
  {
    this.toiletBuilding = toiletBuilding;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      toiletBuilding.startCleaning();
      toiletBuilding.clean();
      System.out.println(name + " \"Cleaning time ...\"");
      toiletBuilding.endCleaning();

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
