public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    Thread num1 = new Thread(new Numbers(0, 25000));
    Thread num2 = new Thread(new Numbers(25000, 50000));
    Thread num3 = new Thread(new Numbers(50000, 75000));
    Thread num4 = new Thread(new Numbers(75000, 100000));

    num1.start();
    num1.join();
    num2.start();
    num2.join();
    num3.start();
    num3.join();
    num4.start();
    num4.join();
  }
}
