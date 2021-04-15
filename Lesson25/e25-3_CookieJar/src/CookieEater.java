public class CookieEater implements Runnable
{
  private CookieJar cookieJar;
  private String name;

  public CookieEater(CookieJar cookieJar, String name)
  {
    this.cookieJar = cookieJar;
    this.name = name;
  }

  @Override public void run()
  {
    while (true)
    {
      cookieJar.eat(name);

      //  Simulate cookie eating time...
      try
      {
        Thread.sleep(500);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
}
