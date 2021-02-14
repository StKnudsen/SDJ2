public class Numbers implements Runnable
{
  private int runs;

  public Numbers(int runs)
  {
    this.runs = runs;
  }

  @Override public void run()
  {
    for (int i = 0; i < runs; i++)
    {
      System.out.println("Index: " + i);

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        //
      }
    }
  }
}
