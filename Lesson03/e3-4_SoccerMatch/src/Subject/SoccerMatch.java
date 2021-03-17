package Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject
{
  private PropertyChangeSupport propertyChangeSupport;
  private final String team0 = "Dream Team";
  private final String team1 = "Old Boys";

  public SoccerMatch()
  {
    propertyChangeSupport = new PropertyChangeSupport(this);
  }

  public void startMatch()
  {
    System.out.println("Match starting \n\n");
    Random random = new Random();
    for (int i = 0; i < 90; i++)
    {

      int rand = random.nextInt(100);
      int whichTeam = random.nextInt(2);

      if (rand < 8)
      {
        scoreGoal(whichTeam);    // score goal
      }
      else if (rand < 12)
      {
        roughTackle(whichTeam);  // penalty
      }

      try
      {
        Thread.sleep(100);
      }
      catch (InterruptedException e)
      {
        break;
      }
    }

    System.out.println("\nMatch ended");
  }

  private void roughTackle(int whichTeam)
  {
    if (whichTeam == 0)
    {
      System.out.println(team0 + " Rough Tackle");
      propertyChangeSupport.firePropertyChange("DreamTeamRoughTackle", null, 1);
    }
    else
    {
      System.out.println(team1 + " Rough Tackle");
      propertyChangeSupport.firePropertyChange("OldBoysRoughTackle", null, 1);
    }

    System.out.println("");
  }

  private void scoreGoal(int whichTeam)
  {
    if (whichTeam == 0)
    {
      System.out.println(team0 + " scored");
      propertyChangeSupport.firePropertyChange("DreamTeamScored", null, 1);
    }
    else
    {
      System.out.println(team1 + " scored");
      propertyChangeSupport.firePropertyChange("OldBoysScored", null, 1);
    }

    System.out.println("");
  }

  @Override public void addPropertyChangeListener(
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }
}
