package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Referee implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    react(evt);
  }

  private void react(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamRoughTackle"))
    {
      System.out.println("Referee gives Dream Team a yellow card for a rough tackle.");
    }

    if (evt.getPropertyName().equals("OldBoysRoughTackle"))
    {
      System.out.println("Referee gives Old Boys a yellow card for a rough tackle.");
    }
  }
}
