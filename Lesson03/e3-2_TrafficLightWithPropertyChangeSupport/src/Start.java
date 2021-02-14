import Observers.Car;
import Subject.TrafficLight;

public class Start
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight = new TrafficLight();

    trafficLight.addPropertyChangeListener(new Car(1));
    trafficLight.addPropertyChangeListener(new Car(2));

    trafficLight.start();
  }
}
