public class CookieBaker implements Runnable
{
  private CookieJar cookieJar;

  public CookieBaker(CookieJar cookieJar)
  {
    this.cookieJar = cookieJar;
  }

  @Override public void run()
  {
    while (true)
    {


      cookieJar.startBaking("Chocolate chip");

      //  Time it takes to bake cookies
      try
      {
        Thread.sleep(2500);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      cookieJar.finishedBaking();
    }
  }
}
