public class Start
{
  public static void main(String[] args)
  {
    Thread hiPrint = new Thread(new Hi());
    Thread helloPrint = new Thread(new Hello());

    //  Threads, so they alternate
    //hiPrint.start();
    //helloPrint.start();

    //  Just calling the method, no alternating
    hiPrint.run();
    helloPrint.run();
  }
}
