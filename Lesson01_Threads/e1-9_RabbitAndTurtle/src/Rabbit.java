import java.util.Random;

public class Rabbit implements Runnable
{
  private Turtle turtle;
  private RunControlling runControlling;

  Random r = new Random();
  int j = r.nextInt(1000);

  public Rabbit(Turtle turtle, RunControlling runControlling)
  {
    this.turtle = turtle;
    this.runControlling = runControlling;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      while (runControlling.getRabbit() - runControlling.getTurtle() <= 50)
      {
        runControlling.incRab();
      }
      try
      {
        Thread.sleep(j);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Rabbit: " + runControlling.getRabbit());
      if (runControlling.getRabbit() >= 1000)
      {
        System.out.println(runControlling.winnerCheck());
        return;
      }
      if (runControlling.getTurtle() >= 1000)
      {
        return;
      }
    }
  }
}
