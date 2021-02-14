package Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Random;

public class SoccerMatch implements PropertyChangeSubject
{
	private PropertyChangeSupport propertyChangeSupport;
	private String team0 = "Dream Team";
	private String team1 = "Old Boys";
	private int dreamScore, oldScore;

	public SoccerMatch()
	{
		propertyChangeSupport = new PropertyChangeSupport(this);
		dreamScore = 0;
		oldScore = 0;
	}

	public void startMatch() {
		System.out.println("Match starting \n\n");
		Random random = new Random();
		for(int i = 0; i < 90; i++) {

			int rand = random.nextInt(100);
			int whichTeam = random.nextInt(2);

			if(rand < 8) {
				// score goal
				scoreGoal(whichTeam);
			} else if(rand < 12) {
				// penalty
				roughTackle(whichTeam);
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}
		}
		
		System.out.println("\n\nMatch ended");
	}

	private void roughTackle(int whichTeam) {
		if(whichTeam == 0) {
			System.out.println(team0 + " Rough Tackle");
			propertyChangeSupport.firePropertyChange("DreamTeamRoughTackle", -1, 1);
		} else {
			System.out.println(team1 + " Rough Tackle");
			propertyChangeSupport.firePropertyChange("OldBoysRoughTackle", -1, 1);
		}
	}

	private void scoreGoal(int whichTeam) {
		if(whichTeam == 0) {
			System.out.println(team0 + " scored");
			propertyChangeSupport.firePropertyChange("DreamTeamScored", -1, 1);
		} else {
			System.out.println(team1 + " scored");
			propertyChangeSupport.firePropertyChange("OldBoysScored", -1, 1);
		}
	}

	@Override public void addPropertyChangeListener(
			PropertyChangeListener listener)
	{
		propertyChangeSupport.addPropertyChangeListener(listener);
	}
}
