/*
 *  Adapter pattern - real subject
 */

import java.util.ArrayList;

public class MyArrayList implements ListADT
{
  private ArrayList<String> arrayList;

  public MyArrayList()
  {
    arrayList = new ArrayList<>();
  }

  @Override public void add(String s)
  {
    arrayList.add(s);
  }

  @Override public void add(int idx, String s)
  {
    arrayList.add(idx,s);
  }

  @Override public void set(int idx, String s)
  {
    arrayList.set(idx,s);
  }

  @Override public String get(int idx)
  {
    return arrayList.get(idx);
  }

  @Override public String remove(int idx)
  {
    return arrayList.remove(idx);
  }

  @Override public String remove(String s)
  {
    arrayList.remove(s);
    return s;
  }

  @Override public int indexOf(String s)
  {
    return arrayList.indexOf(s);
  }

  @Override public boolean contains(String s)
  {
    return arrayList.contains(s);
  }

  @Override public boolean isEmpty()
  {
    return arrayList.isEmpty();
  }

  @Override public int size()
  {
    return arrayList.size();
  }
}
