public class SharedResource
{
  private int i;
  private int activeReaders = 0;
  private int activeWriters = 0;
  private int waitingReaders = 0;
  private int waitingWriters = 0;
  private static int MAX_READERS = 5;

  public void write()
  {
    try
    {
      Thread.sleep(200);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    i++;
  }

  private int read()
  {
    try
    {
      Thread.sleep(500);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println("Active Readers: " + activeReaders);
    return i;
  }

  //  Hvornår skal 'readers' vente
  public synchronized void acquireRead()
  {
    waitingReaders++;
    //System.out.println(activeReaders);

    while (activeWriters > 0 || waitingWriters > 0 || activeReaders >= MAX_READERS)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    activeReaders++;
    waitingReaders--;
  }

  public synchronized void releaseRead()
  {
    activeReaders--;
    if (activeReaders == 0)
    {
      notifyAll(); // notify one waiting writer
    }
    //System.out.println("Release active readers: " + activeReaders);
  }

  public synchronized void acquireWrite()
  {
    waitingWriters++;
    while (activeReaders > 0 || activeWriters > 0)  // || waitingReaders>0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    waitingWriters--;
    activeWriters++;
  }

  public synchronized void releaseWrite()
  {
    activeWriters--;
    notifyAll(); // notify all waiting readers
  }

  public int safeRead()
  {
    acquireRead();
    int value = read();
    releaseRead();
    return value;
  }
}
