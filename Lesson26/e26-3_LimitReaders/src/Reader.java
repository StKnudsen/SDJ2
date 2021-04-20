import java.util.Random;

public class Reader implements Runnable
{
  private SharedResource resource;
  private String name;
  Random random = new Random();

  public Reader(SharedResource resource, String name)
  {
    this.resource = resource;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      resource.acquireRead();
      System.out.println(name + " read:" + resource.safeRead());
      resource.releaseRead();
      try
      {
        Thread.sleep(100 + random.nextInt(100));
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
