import Observers.*;
import Subject.SoccerMatch;

public class Main
{
  public static void main(String[] args)
  {
    SoccerMatch soccerMatch = new SoccerMatch();

    soccerMatch.addPropertyChangeListener(new OldBoysFan());
    soccerMatch.addPropertyChangeListener(new DreamTeamFan());
    soccerMatch.addPropertyChangeListener(new Referee());
    soccerMatch.addPropertyChangeListener(new AngryCoach());
    soccerMatch.addPropertyChangeListener(new ScoreBoard());
    soccerMatch.addPropertyChangeListener(new Medic());

    soccerMatch.startMatch();
  }
}
