public class Numbers implements Runnable
{
  private final int runs;

  public Numbers(int runs)
  {
    this.runs = runs;
  }

  @Override public void run()
  {
    while (true)
    {
      for (int i = 0; i < runs; i++)
      {
        System.out.println(i);
      }
    }
  }
}
