package Observers;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ScoreBoard implements PropertyChangeListener
{
  private int oldBoysScore, dreamTeamScore;

  public ScoreBoard()
  {
    oldBoysScore = 0;
    dreamTeamScore = 0;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    if (evt.getPropertyName().equals("OldBoysScored"))
    {
      oldBoysScore++;
      printScore();
    }

    if (evt.getPropertyName().equals("DreamTeamScored"))
    {
      dreamTeamScore++;
      printScore();
    }
  }

  private void printScore()
  {
    System.out.println("##   Dream Team: " + dreamTeamScore + "  -  Old Boys: " + oldBoysScore + "  ##");
  }
}
