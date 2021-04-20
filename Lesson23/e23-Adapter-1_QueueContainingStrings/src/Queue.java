import java.util.ArrayList;

public class Queue implements StringQueue
{
  ArrayList<String> list;
  int cap;

  public Queue(int cap)
  {
    list = new ArrayList<>();
    this.cap = cap;
  }

  @Override public String toString()
  {
    return "Queue{" + "list=" + list + '}';
  }

  @Override public void enqueue(String element)
  {
    if (list.size() >= cap)
    {
      System.out.println("Nope");
      return;
    }
    list.add(element);
  }

  @Override public String dequeue()
  {
    String listItem = list.get(0);
    list.remove(0);
    return listItem;
  }

  @Override public int size()
  {
    return list.size();
  }

  @Override public int indexOf(String element)
  {
    return list.indexOf(element);
  }

  @Override public boolean isEmpty()
  {
    return list.isEmpty();
  }

  @Override public boolean contains(String element)
  {
    return list.contains(element);
  }

  @Override public String first()
  {
    return list.get(0);
  }
}