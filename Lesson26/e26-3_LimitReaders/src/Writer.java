public class Writer implements Runnable
{
  private SharedResource resource;
  private String name;

  public Writer(SharedResource resource, String name)
  {
    this.resource = resource;
    this.name = name;
  }

  @Override public void run()
  {
    for (int i = 0; i < 100; i++)
    {
      resource.acquireWrite();
      resource.write();
      System.out.println(name + " wrote");
      resource.releaseWrite();
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
