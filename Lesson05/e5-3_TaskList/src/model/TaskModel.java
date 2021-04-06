package model;

import util.PropertyChangeSubject;

public interface TaskModel extends PropertyChangeSubject
{
  public void addTask(String owner, String description);

  public Task getNextTask();
}
