package radiator;

public class Power3State implements RadiatorState
{
  private final int POWER = 3;
  private Radiator radiator;
  private Thread thread;

  public Power3State(Radiator radiator)
  {
    this.radiator = radiator;
    thread = new Thread(this::runThread);
    thread.setDaemon(true);
    thread.start();
  }

  private void runThread()
  {
    try
    {
      Thread.sleep(10000);
      radiator.setPowerState(new Power2State());
    }
    catch (InterruptedException e)
    {
      //e.printStackTrace();
    }
  }

  @Override public void turnUp(Radiator radiator)
  {
    //
  }

  @Override public void turnDown(Radiator radiator)
  {
    thread.interrupt();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
