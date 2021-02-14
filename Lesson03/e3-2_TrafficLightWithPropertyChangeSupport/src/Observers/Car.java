package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Car implements PropertyChangeListener//implements LightObserver
{
  private int id;

  public Car(int id)
  {
    this.id = id;
  }

  public void setLight(PropertyChangeEvent evt)
  {
    if ("GREEN".equals(evt.getNewValue()))
    {
      System.out.println("observers.Car " + id + " drives");
    }
    else if ("YELLOW".equals(evt.getNewValue()))
    {
      if ("RED".equals(evt.getOldValue()))
      {
        System.out.println("observers.Car " + id + " turns engine on");
      }
      else
      {
        System.out.println("observers.Car " + id + " slows down");
      }
    }
    else if ("RED".equals(evt.getNewValue()))
    {
      System.out.println("observers.Car " + id + " stops");
    }
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    setLight(evt);
  }
}
