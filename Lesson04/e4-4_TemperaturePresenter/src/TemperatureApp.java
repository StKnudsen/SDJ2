import javafx.application.Application;
import javafx.stage.Stage;
import external.Termometer;
import mediator.TemperatureModel;
import mediator.TemperatureModelManager;
import core.ViewHandler;

public class TemperatureApp extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel temperatureModel = new TemperatureModelManager();

    // external.termometer
    Thread t1 = new Thread(new Termometer(temperatureModel,"t1", 2, 1));
    Thread t2 = new Thread(new Termometer(temperatureModel,"t2", 2, 7));
    t1.start();
    t2.start();

    // View
    ViewHandler view = new ViewHandler(temperatureModel);
    view.start(primaryStage);
  }
}
