/*
 *  Adapter pattern - proxy
 */

public class BoundedArrayList implements ListADT
{
  private MyArrayList myArrayList;

  public BoundedArrayList()
  {
    myArrayList = new MyArrayList();
  }

  @Override public void add(String s)
  {
    myArrayList.add(s);
  }

  @Override public void add(int idx, String s)
  {
    myArrayList.add(idx,s);
  }

  @Override public void set(int idx, String s)
  {
    myArrayList.set(idx,s);
  }

  @Override public String get(int idx)
  {
    return myArrayList.get(idx);
  }

  @Override public String remove(int idx)
  {
    return myArrayList.remove(idx);
  }

  @Override public String remove(String s)
  {
    return myArrayList.remove(s);
  }

  @Override public int indexOf(String s)
  {
    return myArrayList.indexOf(s);
  }

  @Override public boolean contains(String s)
  {
    return myArrayList.contains(s);
  }

  @Override public boolean isEmpty()
  {
    return myArrayList.isEmpty();
  }

  @Override public int size()
  {
    return myArrayList.size();
  }
}
