public class CounterDecrementer implements Runnable
{
  private int updates;
  private Counter counter;

  public CounterDecrementer(int updates, Counter counter)
  {
    this.updates = updates;
    this.counter = counter;
  }

  @Override public void run()
  {
    for (int i = 0; i < updates; i++)
    {
      try
      {
        counter.decrement();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    System.out.println(counter.getValue() + ": " + Thread.currentThread().getName());
  }
}
