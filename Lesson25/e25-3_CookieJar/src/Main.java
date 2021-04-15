public class Main
{
  public static void main(String[] args)
  {
    CookieJar cookieJar = new CookieJar(16);

    CookieBaker cookieBaker = new CookieBaker(cookieJar);

    CookieEater cookieEater1 = new CookieEater(cookieJar, "Tina");
    CookieEater cookieEater2 = new CookieEater(cookieJar, "Line");
    CookieEater cookieEater3 = new CookieEater(cookieJar, "Stefan");

    new Thread(cookieBaker).start();

    new Thread(cookieEater1).start();
    new Thread(cookieEater2).start();
    new Thread(cookieEater3).start();
  }
}
