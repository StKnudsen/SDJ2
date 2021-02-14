public class Main
{
  public static void main(String[] args)
  {
    Termometer termometer1 = new Termometer("t1", 2,1);
    Termometer termometer2 = new Termometer("t2", 2,7);

    Thread t1 = new Thread(termometer1);
    Thread t2 = new Thread(termometer2);

    t1.start();
    t2.start();
  }
}
