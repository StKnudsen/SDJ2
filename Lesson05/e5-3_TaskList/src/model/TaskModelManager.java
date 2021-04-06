package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskModelManager implements TaskModel
{
  private List<Task> tasks;
  PropertyChangeSupport propertyChangeSupport;

  public TaskModelManager()
  {
    tasks = new ArrayList<>();
  }

  private String calcTimeStamp()
  {
    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy/MM/ss HH:mm:ss");
    Date now = new Date();
    return sdfDate.format(now);
  }

  @Override public void addTask(String owner, String description)
  {
    Task task = new Task(owner, description, calcTimeStamp());
    tasks.add(task);

    propertyChangeSupport.firePropertyChange("TaskAdded", null, task);
  }

  @Override public Task getNextTask()
  {
    if (!tasks.isEmpty())
    {
      Task task = tasks.remove(0);
      propertyChangeSupport.firePropertyChange("TaskRemoved", null, task);
      return task;
    }

    return null;
  }

  @Override public void addPropertyListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(listener);
  }

  @Override public void addPropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removePropertyListener(PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(listener);
  }

  @Override public void removePropertyListener(String eventName,
      PropertyChangeListener listener)
  {
    propertyChangeSupport.removePropertyChangeListener(eventName, listener);
  }
}
