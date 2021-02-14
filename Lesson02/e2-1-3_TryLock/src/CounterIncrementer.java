public class CounterIncrementer implements Runnable
{
  private Counter counter;

  public CounterIncrementer(Counter counter)
  {
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      counter.IncrementCount();
      try
      {
        Thread.sleep(1);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    System.out.println(counter.getCount());
  }
}
