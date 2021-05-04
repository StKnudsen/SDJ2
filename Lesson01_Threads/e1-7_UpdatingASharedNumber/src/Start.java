public class Start
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();

    CounterIncrementer counterIncrementer = new CounterIncrementer(counter);

    Thread t1 = new Thread(new CounterIncrementer(counter));
    Thread t2 = new Thread(new CounterIncrementer(counter));

    t1.start();
    t2.start();
  }
}
