public class main
{
  public static void main(String[] args) throws InterruptedException
  {
    Thread t1 = new Thread(new LogUser());
    Thread t2 = new Thread(new LogUser());

    t1.start();
    t2.start();

    t1.join();
    t2.join();

    System.out.println(Log.getInstance().getAll().toString());
  }
}
