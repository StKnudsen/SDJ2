public class Bear implements Runnable
{
  @Override public void run()
  {
    boolean wellRested = true;
    System.out.println("Bear: \"I'm going to sleep\"");
    for (int i = 0; i < 6; i++)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        System.out.println("*You woke up the bear*");
        wellRested = false;
      }
    }

    if (wellRested)
    {
      System.out.println("Bear: \"I'm well rested\"");
    }
  }
}
