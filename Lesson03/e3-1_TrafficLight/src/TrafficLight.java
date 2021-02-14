import java.util.ArrayList;
import java.util.List;

public class TrafficLight
{
  List<LightObserver> lightObservers;

  private final String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int count = 2;
  private String currentLight;

  public TrafficLight()
  {
    currentLight = lights[2];
    lightObservers = new ArrayList<>();
  }

  public void addLightObserver(LightObserver lightObserver)
  {
    lightObservers.add(lightObserver);
    lightObserver.setLight(currentLight);
  }

  public void start() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(2000);
      count = (count + 1) % 4;
      currentLight = lights[count];
      System.out.println("\nLight is " + currentLight);

      lightChanged();
    }
  }

  private void lightChanged()
  {
    for (LightObserver lightObserver : lightObservers)
    {
      lightObserver.setLight(currentLight);
    }
  }
}
