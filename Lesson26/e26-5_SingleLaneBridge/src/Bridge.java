public class Bridge implements Lane
{
  private int activeBlueCars;
  private int waitingBlueCars;
  private int activeRedCars;
  private int waitingRedCars;

  /*
   *  Red cars
   */
  @Override public synchronized void enterFromTheLeft()
  {
    waitingRedCars++;

    while (activeBlueCars > 0)
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

    activeRedCars++;
    waitingRedCars--;
  }

  @Override public synchronized void exitToTheRight()
  {
    activeRedCars--;

    if (activeRedCars == 0)
    {
      notifyAll();
    }
  }

  /*
   *  Blue cars
   */
  @Override public synchronized void enterFromTheRight()
  {
    waitingBlueCars++;

    while (activeRedCars > 0)
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

    activeBlueCars++;
    waitingBlueCars--;
  }

  @Override public synchronized void exitToTheLeft()
  {
    activeBlueCars--;

    if (activeBlueCars == 0)
    {
      notifyAll();
    }
  }
}
