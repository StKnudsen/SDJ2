package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Medic implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    react(evt);
  }

  private void react(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamRoughTackle") || evt.getPropertyName().equals("OldBoysRoughTackle"))
    {
      System.out.println("The medic team rushes to aid the hurting player - gives him a comb and a mirror..");
    }
  }
}
