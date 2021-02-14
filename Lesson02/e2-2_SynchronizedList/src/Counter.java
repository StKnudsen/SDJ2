public class Counter implements Runnable
{
  private ListContainer listContainer;

  public Counter(ListContainer listContainer)
  {
    this.listContainer = listContainer;
  }

  @Override public void run()
  {
    for (int i = 0; i < 100000; i++)
    {
      listContainer.add(i);
      System.out.println("add " + i);
    }

    System.out.println("Counter contains #" + listContainer.getLength() + " numbers");
  }
}
