public class Numbers implements Runnable
{
  private int x;
  private int y;

  public Numbers(int x, int y)
  {
    this.x = x;
    this.y = Math.max(y, x);
  }

  @Override public void run()
  {
    for (int i = x; i < y; i++)
    {
      System.out.println("nummer: " + i);
    }
  }
}
