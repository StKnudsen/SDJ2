package core;

import javafx.application.Application;
import javafx.stage.Stage;

public class TaskListApp extends Application
{
  @Override
  public void start(Stage stage)
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
  }
}
