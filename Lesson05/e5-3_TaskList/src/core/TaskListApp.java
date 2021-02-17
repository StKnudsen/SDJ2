package core;

import javafx.stage.Stage;

public class TaskListApp
{
  public void start(Stage stage)
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

  }
}
