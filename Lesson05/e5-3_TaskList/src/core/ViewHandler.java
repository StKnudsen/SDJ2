package core;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.add.AddTaskController;
import view.all.NextTaskController;

public class ViewHandler
{
  private Stage stage;
  private Scene addTaskViewScene;
  private Scene removeTaskViewScene;
  private Scene allTaskViewScene;

  private ViewModelFactory viewModelFactory;

  private AddTaskController addTaskController;
  private NextTaskController nextTaskController;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {

  }

  public void openAllTaskView()
  {

  }

  public void openAddTaskView()
  {

  }

  public void openGetNextTaskView()
  {

  }

  private Parent getRootByPath(String path)
  {
    return null;
  }
}
