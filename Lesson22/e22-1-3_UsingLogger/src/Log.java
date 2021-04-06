import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Log
{
  static Log instance;
  static Lock lock = new ReentrantLock();

  public static Log getInstance()
  {
    if (instance == null)
    {
      synchronized (lock)
      {
        if (instance == null)
        {
          instance = new Log();
        }
      }
    }

    return instance;
  }

  private Queue<LogLine> logQueue;

  private Log()
  {
    logQueue = new LinkedList<>();
  }

  public Queue<LogLine> getAll()
  {
    return logQueue;
  }

  public synchronized void add(String logEntry)
  {
    if (logEntry == null || "".equals(logEntry))
    {
      return;
    }
    logQueue.add(new LogLine(logEntry,
        new Timestamp(System.currentTimeMillis()).toString()));
  }
}
