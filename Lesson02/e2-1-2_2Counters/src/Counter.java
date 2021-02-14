import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int countDooku;
  private int countDracula;

  private Lock lockDooku = new ReentrantLock();
  private Lock lockDracula = new ReentrantLock();

  public Counter()
  {
    countDooku = 0;
    countDracula = 0;
  }

  public void incDooku()
  {
    synchronized (lockDooku)
    {
      countDooku++;
    }
  }

  public void incDracula()
  {
    synchronized (lockDracula)
    {
      countDracula++;
    }
  }


  public int getCountDooku()
  {
    return countDooku;
  }

  public int getCountDracula()
  {
    return countDracula;
  }
}
