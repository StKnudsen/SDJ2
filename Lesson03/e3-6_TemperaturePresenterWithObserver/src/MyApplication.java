import javafx.application.Application;
import javafx.stage.Stage;
import temperature.mediator.TemperatureModel;
import temperature.mediator.TemperatureModelManager;
import temperature.view.ViewHandler;

public class MyApplication extends Application
{
  public void start(Stage primaryStage)
  {
    // Model
    TemperatureModel model = new TemperatureModelManager();

    // Termometer
    Thread t1 = new Thread(new Termometer(model,"t1", 2, 1));
    Thread t2 = new Thread(new Termometer(model,"t2", 2, 7));
    t1.start();
    t2.start();

    // View
    ViewHandler view = new ViewHandler(model);
    view.start(primaryStage);
  }
}
