public class Counter
{
  private int count;

  public Counter()
  {
    count = 0;
  }

  //public synchronized void IncrementCount() // #A Option synchronize whole method
  public synchronized void IncrementCount()
  {
    // #B synchronize partial method
    synchronized (this){
      count++;
    }
    //count++; // #A Option synchronize whole method
  }

  public int getCount()
  {
    return count;
  }
}
