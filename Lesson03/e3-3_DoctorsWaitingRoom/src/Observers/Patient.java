package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Patient implements PropertyChangeListener
{
  private int ticketNumber;

  public Patient(int ticketNumber)
  {
    this.ticketNumber = ticketNumber;
  }



  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    reactOnNumber(evt);
  }

  private void reactOnNumber(PropertyChangeEvent evt)
  {
    System.out.println("Patient " + ticketNumber + " looks up");
    if (evt.getNewValue().equals(ticketNumber))
    {
      System.out.println("Patient " + ticketNumber + " goes to the doctor's room");
    }
    else
    {
      System.out.println("Patient " + ticketNumber + " goes back to looking at phone");
    }

  }
}
