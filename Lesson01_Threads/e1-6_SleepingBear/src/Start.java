public class Start
{
  public static void main(String[] args)
  {
    Thread bear = new Thread(new Bear());
    Thread man = new Thread((new PokingMan(bear)));

    bear.start();
    man.start();
  }
}
