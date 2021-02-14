public class main
{
  public static void main(String[] args) throws InterruptedException
  {
    Counter counter = new Counter(1, 100, 0);

    Thread t1 = new Thread(new CounterIncrementer(200, counter));
    Thread t2 = new Thread(new CounterIncrementer(200, counter));
    Thread t3 = new Thread(new CounterDecrementer(200, counter));
    Thread t4 = new Thread(new CounterDecrementer(200, counter));
    Thread t5 = new Thread(new CounterIncrementer(0, counter));

    t1.start();
    t2.start();
    t3.start();
    t4.start();

    //t5.join(counter.getValue());

  }
}
