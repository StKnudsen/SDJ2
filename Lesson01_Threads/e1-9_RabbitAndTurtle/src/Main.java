public class Main
{
  public static void main(String[] args)
  {
    RunControlling runControlling = new RunControlling();
    Turtle turtle = new Turtle(runControlling);
    Thread t = new Thread(turtle);
    Thread r = new Thread(new Rabbit(turtle, runControlling));

    t.start();
    r.start();
  }
}
