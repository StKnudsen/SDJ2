package Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TrafficLight implements PropertyChangeSubject
{
  //List<LightObserver> lightObservers;
  PropertyChangeSupport propertyChangeSupport;

  private final String[] lights = {"GREEN", "YELLOW", "RED", "YELLOW"};
  private int count = 2;
  private String currentLight;

  public TrafficLight()
  {
    currentLight = lights[2];
    //lightObservers = new ArrayList<>();
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  //public void addLightObserver(LightObserver lightObserver)
  //{
  //  lightObservers.add(lightObserver);
  //  lightObserver.setLight(currentLight);
  //}
  //public void addListener(PropertyChangeListener listener)
  //{
  //  propertyChangeSupport.addPropertyChangeListener(listener);
  //  listener.propertyChange(new PropertyChangeEvent(this, "LightChanged", currentLight, currentLight));
  //}

  public void start() throws InterruptedException
  {
    for (int i = 0; i < 10; i++)
    {
      Thread.sleep(2000);
      count = (count + 1) % 4;
      String previous = currentLight;
      currentLight = lights[count];
      System.out.println("\nLight is " + currentLight);

      lightChanged(previous, currentLight);
    }
  }

  private void lightChanged(String previous, String current)
  {
    //for (LightObserver lightObserver : lightObservers)
    //{
    //  lightObserver.setLight(currentLight);
    //}
    propertyChangeSupport.firePropertyChange("LightChanged", previous, current);
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
    listener.propertyChange(new PropertyChangeEvent(this, "LightChanged", currentLight, currentLight));
  }
}
