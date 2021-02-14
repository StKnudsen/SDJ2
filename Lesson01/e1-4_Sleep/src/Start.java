public class Start
{
  public static void main(String[] args)
  {

    //Thread numbers = new Thread(new Numbers(4));
    //numbers.start();

    /*
     *  With lambda
     */
    (new Thread(() -> {
      for (int i = 0; i < 4; i++)
      {
        System.out.println("Nummer: " + i);

        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          //
        }
      }
    })).start();
  }
}
