public class Termometer implements Runnable
{
  private String id;
  private double t;

  public Termometer(String id, double t)
  {
    this.id = id;
    this.t = t;
  }

  public void temperature(double t, int p, int d, double t0, int s)
  {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0)
    {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    this.t =  t;
  }

  @Override public void run()
  {
    while (true)
    {
      temperature(t, 0, 1, 0, 6);
      System.out.println(id + " " + t);

      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
