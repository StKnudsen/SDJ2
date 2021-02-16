import javafx.application.Application;
import javafx.stage.Stage;
import external.Termometer;
import mediator.TemperatureModel;
import mediator.TemperatureModelManager;
import view.temperature.ViewHandler;

public class TemperatureApp extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // external.Termometer
    Thread t1 = new Thread(new Termometer(model,"t1", 2, 1));
    Thread t2 = new Thread(new Termometer(model,"t2", 2, 7));
    t1.start();
    t2.start();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
