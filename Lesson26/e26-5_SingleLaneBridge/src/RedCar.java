public class RedCar implements Runnable
{
  private Bridge bridge;
  private String name;

  public RedCar(Bridge bridge, String name)
  {
    this.bridge = bridge;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      bridge.enterFromTheLeft();
      System.out.println(name + " Gargamel car driving from the left ...");
      bridge.exitToTheRight();

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
