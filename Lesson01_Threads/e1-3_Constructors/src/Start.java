public class Start
{
  public static void main(String[] args)
  {
    Thread numPrint = new Thread(new Numbers(57));
    Thread letPrint = new Thread(new Letters(33));

    numPrint.start();
    letPrint.start();
  }
}
