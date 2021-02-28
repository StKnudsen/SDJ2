public class Start
{
  public static void main(String[] args)
  {
    Counter c = new Counter();

    Thread t1 = new Thread(new CounterIncrementer(c));
    Thread t2 = new Thread(new CounterIncrementer(c));

    t1.start();
    t2.start();
  }
}
