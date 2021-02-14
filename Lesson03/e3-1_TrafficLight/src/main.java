public class main
{
  public static void main(String[] args) throws InterruptedException
  {
    TrafficLight trafficLight = new TrafficLight();

    trafficLight.addLightObserver(new Car(1));
    trafficLight.addLightObserver(new Car(2));
    trafficLight.addLightObserver(new Taxi(3));
    trafficLight.addLightObserver(new SleepyDriver(4));
    trafficLight.addLightObserver(new Pedestrian(5));

    trafficLight.start();
  }
}
