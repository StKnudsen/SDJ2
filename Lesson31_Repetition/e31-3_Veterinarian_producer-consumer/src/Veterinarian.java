public class Veterinarian implements Runnable
{
  WaitingRoom waitingRoom;

  public Veterinarian(WaitingRoom waitingRoom)
  {
    this.waitingRoom = waitingRoom;
  }

  @Override public void run()
  {
    while(true)
    {
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      waitingRoom.curePatient();
    }
  }
}
