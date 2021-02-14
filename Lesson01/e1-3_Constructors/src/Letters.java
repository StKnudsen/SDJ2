public class Letters implements Runnable
{
  private final int runs;

  public Letters(int runs)
  {
    this.runs = runs;
  }

  @Override public void run()
  {
    while (true)
    {
      for (int i = 0; i < runs; i++)
      {
        System.out.println( (char) (i + 97) );
      }
    }
  }
}
