import java.util.ArrayList;
import java.util.List;

public class ListContainer
{
  private List<Integer> list;

  public ListContainer()
  {
    list = new ArrayList<>();
  }

  public synchronized void add(int i)
  {
    list.add(i);
  }

  public int getLength()
  {
    return list.size();
  }
}
