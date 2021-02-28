import java.util.Random;

public class Rabbit implements Runnable
{
  private Turtle turtle;
  private int count;

  public Rabbit(Turtle turtle)
  {
    this.turtle = turtle;
    count = 0;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      if (count - turtle.getCount() >= 50)
      {
         Random r = new Random();
         
      }
    }
  }

  private void napTime()
  {
    Random r = new Random();
    int i = r.nextInt(1000);

    try
    {
      Thread.sleep(i);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
  }
}
