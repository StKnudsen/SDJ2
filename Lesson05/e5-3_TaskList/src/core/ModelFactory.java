package core;

import model.TaskModel;
import model.TaskModelManager;

public class ModelFactory
{
  private TaskModel taskModelManager;

  public ModelFactory()
  {
    taskModelManager = new TaskModelManager();
  }

  public TaskModel getTaskModelManager()
  {
    return taskModelManager;
  }
}
