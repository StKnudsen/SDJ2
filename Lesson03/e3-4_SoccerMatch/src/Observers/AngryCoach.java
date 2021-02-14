package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AngryCoach implements PropertyChangeListener
{
  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    react(evt);
  }

  private void react(PropertyChangeEvent evt)
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
      System.out.println("Old Boys Coach: \"%&*#\" YEEEAAH!");
    }

    if (evt.getPropertyName().equals("DreamTeamScored"))
    {
      System.out.println("Old Boys Coach: \"%&*#\" YEEEAAH!");
    }
  }
}
