package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("DreamTeamRoughTackle"))
    {
      System.out.println("Old Boys Coach yells at the Referee \"%&*%&%*\"");
    }

    if (evt.getPropertyName().equals("OldBoysRoughTackle"))
    {
      System.out.println("Dream Teams Coach yells at the Referee \"%&*%&%*\"");
    }

    if (evt.getPropertyName().equals("OldBoysScored"))
    {
      System.out.println("Old Boys Coach \"YES! That's how its done\"");
    }

    if (evt.getPropertyName().equals("DreamTeamScored"))
    {
      System.out.println("Dream Team Boys Coach \"Fork yeah!\"");
    }
  }
}
