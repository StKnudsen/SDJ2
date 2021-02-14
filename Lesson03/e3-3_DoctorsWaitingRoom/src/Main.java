import Observers.Patient;
import Subject.WaitingRoom;

public class Main
{
  public static void main(String[] args)
  {
    WaitingRoom waitingRoom = new WaitingRoom();
    Thread t1 = new Thread(waitingRoom);

    for (int i = 0; i < 3; i++)
    {
      waitingRoom.addPropertyChangeListener(new Patient(i));
    }

    t1.start();
  }
}
