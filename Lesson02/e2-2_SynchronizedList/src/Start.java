public class Start
{
  public static void main(String[] args)
  {
    ListContainer listContainer = new ListContainer();

    Thread t1 = new Thread(new Counter(listContainer));
    Thread t2 = new Thread(new Counter(listContainer));

    t1.start();
    t2.start();
  }
}
