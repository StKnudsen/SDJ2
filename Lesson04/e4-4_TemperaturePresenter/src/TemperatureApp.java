import core.ModelFactory;
import core.ViewModelFactory;
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
    //TemperatureModel temperatureModel = new TemperatureModelManager();
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    //ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    // external.termometer
    Thread t1 = new Thread(new Termometer(modelFactory.getTemperatureModel(), "t1", 2, 1));
    Thread t2 = new Thread(new Termometer(modelFactory.getTemperatureModel(), "t2", 2, 7));
    t1.start();
    t2.start();

    // View
    ViewHandler view = new ViewHandler(viewModelFactory);
    view.start(primaryStage);
  }
}
