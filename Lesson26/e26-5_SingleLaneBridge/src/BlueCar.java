public class BlueCar implements Runnable
{
  private Bridge bridge;
  private String name;

  public BlueCar(Bridge bridge, String name)
  {
    this.bridge = bridge;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      bridge.enterFromTheRight();
      System.out.println(name + " Smurf car driving from the right ...");
      bridge.exitToTheLeft();

      try
      {
        Thread.sleep(400);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
