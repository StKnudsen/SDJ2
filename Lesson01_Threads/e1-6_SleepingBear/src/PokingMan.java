public class PokingMan implements Runnable
{
  private Thread bearThread;

  public PokingMan(Thread bearThread)
  {
    this.bearThread = bearThread;
  }

  @Override public void run()
  {
    for (int i = 0; i < 5; i++)
    {
      System.out.println("PokingMan pokes " + i + " times");

      if (i == 3)
      {
        bearThread.interrupt();
      }

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
    }
  }
}
