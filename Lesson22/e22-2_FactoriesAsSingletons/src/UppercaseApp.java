import core.ModelFactory;
import core.ViewHandler;
import core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    //ModelFactory modelFactory = ModelFactory.getInstance();//new ModelFactory();
    //ViewModelFactory viewModelFactory = ViewModelFactory.getInstance();
    //ViewHandler viewHandler = ViewHandler.getInstance();
    //viewHandler.start();

    ViewHandler.getInstance().start();
  }
}
