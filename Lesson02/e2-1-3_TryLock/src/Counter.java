import com.sun.source.tree.WhileLoopTree;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
  private int count;
  public Lock lock = new ReentrantLock();

  public Counter()
  {
    count = 0;
  }

  public void IncrementCount()
  {
    while (!lock.tryLock())
    {
      System.out.println("Lock was in use..");
    }

    count++;
    lock.unlock();
  }

  public int getCount()
  {
    return count;
  }
}
