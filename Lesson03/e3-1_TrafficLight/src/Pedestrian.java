public class Pedestrian implements LightObserver
{
  private String previousLight;
  private int id;

  public Pedestrian(int id)
  {
    this.id = id;
  }

  @Override public void setLight(String currentLight)
  {
    if ("GREEN".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " waits");
    }
    else if ("YELLOW".equals(currentLight))
    {
      if ("RED".equals(previousLight))
      {
        System.out.println("Pedestrian " + id + " runs faster across the road");
      }
      else
      {
        System.out.println("Pedestrian " + id + " gets ready to cross");
      }
    }
    else if ("RED".equals(currentLight))
    {
      System.out.println("Pedestrian " + id + " crosses the road");
    }

    previousLight = currentLight;
  }
}
