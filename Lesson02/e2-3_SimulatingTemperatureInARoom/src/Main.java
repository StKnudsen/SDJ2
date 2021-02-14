public class Main
{
  public static void main(String[] args)
  {
    Termometer termometer = new Termometer("t1", 15);
    Thread t1 = new Thread(termometer);
    t1.start();
  }
}
