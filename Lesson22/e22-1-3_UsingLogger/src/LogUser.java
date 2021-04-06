public class LogUser implements Runnable
{
  @Override public void run()
  {
    for (int i = 0; i < 1000; i++)
    {
      Log.getInstance().add("Øf " + i);
      //System.out.println("løber her " + i);
    }
  }
}
