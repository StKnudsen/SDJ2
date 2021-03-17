package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class OldBoysFan implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("OldBoysScored"))
    {
      System.out.println(" ... Old Boys fans: YEEEAAH!");
    }

    if (evt.getPropertyName().equals("DreamTeamScored"))
    {
      System.out.println(" ... Old Boys fans: BUUUUUHH!");
    }
  }
}
