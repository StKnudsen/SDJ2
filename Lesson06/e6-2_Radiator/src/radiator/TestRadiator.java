package radiator;

public class TestRadiator
{
  public static void main(String[] args) throws InterruptedException
  {
    Radiator radiator = new Radiator();

    radiator.setPowerState(new OffState());
    System.out.println("Radiator at: " + radiator.getPower());
    radiator.turnUp();
    System.out.println("Radiator at: " + radiator.getPower());
    radiator.turnUp();
    System.out.println("Radiator at: " + radiator.getPower());
    radiator.turnUp();
    System.out.println("Radiator at: " + radiator.getPower());

    for (int i = 0; i < 15; i++)
    {
      Thread.sleep(1000);
      System.out.println("Radiator at: " + radiator.getPower());

      // break before 10 sec..
      if (i == 3)
      {
        radiator.turnDown();
      }
    }
  }
}
