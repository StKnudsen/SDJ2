package view.all;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Task;
import model.TaskModel;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AllTaskViewModel implements PropertyChangeListener
{
  private ObservableList<Task> tasks;
  private ViewHandler viewHandler;
  private TaskModel taskModel;

  public AllTaskViewModel(TaskModel taskModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.taskModel = taskModel;
    tasks = FXCollections.observableArrayList();

    taskModel.addPropertyListener("TaskAdded", this::taskAdded);
    taskModel.addPropertyListener("TaskRemoved", this::taskRemoved);
  }

  private void taskRemoved(PropertyChangeEvent event)
  {
    tasks.remove((Task) event.getNewValue());
  }

  private void taskAdded(PropertyChangeEvent event) {
    tasks.add((Task) event.getNewValue());
  }

  public ObservableList<Task> getTasks() {
    return tasks;
  }

  public void openAddTaskView() {
    viewHandler.openAddTaskView();
  }

  public void openNextTaskView() {
    viewHandler.openGetNextTaskView();
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}
