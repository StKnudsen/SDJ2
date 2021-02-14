public class Counter
{
  private long value;
  private long max;
  private long min;

  public Counter(long value, long max, long min)
  {
    this.value = value;
    this.max = max;
    this.min = min;
  }

  public synchronized void increment() throws InterruptedException
  {
    if (value >= max)
    {
      wait();
    }

    value++;
    System.out.println(Thread.currentThread().getName() + " incremented to " + value);
    notifyAll();
  }

  public synchronized void decrement() throws InterruptedException
  {
    if (value <= min)
    {
      wait();
    }
    value--;
    System.out.println(Thread.currentThread().getName() + " decremented to " + value);
    notifyAll();
  }

  public long getValue()
  {
    return value;
  }
}
