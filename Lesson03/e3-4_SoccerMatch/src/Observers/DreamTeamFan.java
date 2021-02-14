package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DreamTeamFan implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    react(evt);
  }

  private void react(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamScored"))
    {
      System.out.println(" ... Dream Team fans: YEEEAAH!");
    }

    if (evt.getPropertyName().equals("OldBoysScored"))
    {
      System.out.println(" ... Dream Team fans: BUUUUHHH!");
    }
  }
}
