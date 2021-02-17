package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  PropertyChangeSupport support;

  public TaskModelManager()
  {
    tasks = new ArrayList<>();
  }

  private String calcTimeStamp()
  {
    return null;
  }

  @Override public void addTask(String owner, String desc)
  {
    //
  }

  @Override public Task getTask()
  {
    return null;
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    //
  }

  @Override public void addPropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    //
  }

  @Override public void removePropertyListener(PropertyChangeListener listener)
  {
    //
  }

  @Override public void removePropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    //
  }
}
