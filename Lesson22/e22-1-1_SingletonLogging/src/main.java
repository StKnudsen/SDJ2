public class main
{
  public static void main(String[] args)
  {
    Log.getInstance().add("Run!");


    System.out.println(Log.getInstance().getAll().toString());
  }
}
