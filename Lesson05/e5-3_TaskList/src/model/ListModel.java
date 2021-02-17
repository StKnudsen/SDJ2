package model;

import java.beans.PropertyChangeListener;

public interface ListModel
{
  public void addTask(String creator, String description);

  public Task getNextTask();

  public void addListener(String eventName, PropertyChangeListener listener);
}
