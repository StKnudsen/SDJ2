public class Turtle implements Runnable
{
  private RunControlling runControlling;

  public Turtle(RunControlling runControlling)
  {
    this.runControlling = runControlling;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      runControlling.incTur();
      try
      {
        Thread.sleep(10);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Turtle: " + runControlling.getTurtle());
      if(runControlling.getRabbit() >= 1000)
      {
        return;
      }
      if(runControlling.getTurtle() >= 1000)
      {
        System.out.println(runControlling.winnerCheck());
      }
    }
  }
}
