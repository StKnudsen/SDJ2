package Subject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class WaitingRoom implements Runnable, PropertyChangeSubject
{
  PropertyChangeSupport support;
  private int counter;

  public WaitingRoom()
  {
    this.counter = 0;
    support = new PropertyChangeSupport(this);
  }

  @Override public void run()
  {
    for (int i = 0; i < 5; i++)
    {
      System.out.println("Diing!");
      support.firePropertyChange("Number", counter, counter);
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

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {

    support.addPropertyChangeListener(listener);
    listener.propertyChange(new PropertyChangeEvent(this, "Number", counter, counter));
  }
}
