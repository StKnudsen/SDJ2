public class Main
{
  public static void main(String[] args)
  {
    BoundedArrayList boundedArrayList = new BoundedArrayList();

    boundedArrayList.add("Smølf");
    System.out.println(boundedArrayList.contains("Smølf"));
    System.out.println(boundedArrayList.indexOf("Smølf"));
  }
}
