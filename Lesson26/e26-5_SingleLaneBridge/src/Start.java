public class Start
{
  public static void main(String[] args)
  {
    Bridge bridge = new Bridge();

    for (int i = 0; i < 5; i++)
    {
      BlueCar blueCar = new BlueCar(bridge, "<BlueCar> " + i);
      Thread t = new Thread(blueCar);
      t.start();
    }

    for (int i = 0; i < 5; i++)
    {
      RedCar redCar = new RedCar(bridge, "<RedCar> " + i);
      Thread t = new Thread(redCar);
      t.start();
    }
  }
}
