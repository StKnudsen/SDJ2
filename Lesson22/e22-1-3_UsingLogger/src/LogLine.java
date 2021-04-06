public class LogLine
{
  private String logEntry;

  public LogLine(String logEntry, String time)
  {
    this.logEntry = logEntry;
  }

  public String getLogEntry()
  {
    return logEntry;
  }

  @Override public String toString()
  {
    return "\nLogLine{" + "logEntry='" + logEntry + '\'' + '}';
  }
}
