public class Turtle implements Runnable
{
  private int count;

  public Turtle()
  {
    count = 0;
  }

  public int getCount()
  {
    return count;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      try
      {
        Thread.sleep(10);
        count++;
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
