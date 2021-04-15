import java.util.ArrayList;

public class CookieJar
{
  private ArrayList<Cookie> cookies;
  private int cookieTray;
  private String type;

  public CookieJar(int cookieTray)
  {
    this.cookieTray = cookieTray;
    cookies = new ArrayList<>();
  }

  public synchronized void startBaking(String type)
  {
    while (cookies.size() > 4)
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    this.type = type;
    System.out.println("Cookie baker started baking " + type + " cookies");
    notifyAll();
  }

  public synchronized void finishedBaking()
  {
    for (int i = 0; i < cookieTray; i++)
    {
      cookies.add(new Cookie(type));
    }
    System.out.println("Cookie baker finished baking " + type + " cookies");
    System.out.println("-- Cookie Jar now has " + cookies.size() + " cookies! --");
    notifyAll();
  }

  public synchronized void eat(String name)
  {
    while (cookies.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    Cookie cookie = cookies.remove(0);
    System.out.println(name + " is eating " + cookie.getType() + " cookie");
    System.out.println("-- Cookie Jar now has " + cookies.size() + " cookies! --");
    notifyAll();
  }

  public int size()
  {
    return cookies.size();
  }
}
