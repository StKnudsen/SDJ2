package view.remove;

import javafx.collections.ObservableList;
import model.Task;
import model.TaskModel;

import java.util.ArrayList;

public class AllTaskViewModel
{
  private ObservableList<Task> tasks;
  private TaskModel taskModel;

  public AllTaskViewModel(TaskModel taskModel)
  {
    tasks = (ObservableList<Task>) new ArrayList<Task>();
    this.taskModel = taskModel;
  }

  public ObservableList<Task> getTasks()
  {
    return tasks;
  }
}
