public class ToiletBuilding implements PublicToilet
{
  private static int TOILET_CABINS = 5;
  private int activePeeingPeople;
  private int waitingToPee;
  private int activeCleaners;
  private int i;

  public void clean()
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

  private int useToilet()
  {
    try
    {
      Thread.sleep(500);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    return i;
  }

  public int safeRead()
  {
    stepIntoCabin();
    int value = useToilet();
    leaveCabin();
    return value;
  }

  @Override public synchronized void stepIntoCabin()
  {
    waitingToPee++;

    while (activeCleaners > 0 || activePeeingPeople >= TOILET_CABINS)
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

    activePeeingPeople++;
    waitingToPee--;
  }

  @Override public synchronized void leaveCabin()
  {
    activePeeingPeople--;
    if (activePeeingPeople == 0)
    {
      notifyAll();
    }
  }

  @Override public synchronized void startCleaning()
  {
    while (activePeeingPeople > 0 || activeCleaners > 0)
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

    activeCleaners++;
  }

  @Override public synchronized void endCleaning()
  {
    activeCleaners--;
    notifyAll();
  }
}
