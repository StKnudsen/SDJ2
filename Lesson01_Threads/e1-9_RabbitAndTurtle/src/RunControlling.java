public class RunControlling
{
  private int turtle, rabbit;
  private String winner;

  public RunControlling()
  {
    turtle = 0;
    rabbit = 0;
    winner = "No winner...";
  }

  public void incTur()
  {
    turtle++;
  }

  public void incRab()
  {
    rabbit++;
  }

  public String winnerCheck()
  {
    if(turtle >= 1000)
    {
      winner = "Turtle wins!";
    }
    else if(rabbit >= 1000)
    {
      winner = "Rabbit wins!";
    }
    return winner;
  }

  public int getTurtle()
  {
    return turtle;
  }

  public int getRabbit()
  {
    return rabbit;
  }
}
