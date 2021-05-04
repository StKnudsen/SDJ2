package client;

import client.model.ModelFactory;
import client.network.ClientFactory;
import client.view.ViewHandler;
import client.viewmodel.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

@SuppressWarnings("ALL")
public class PersonApp extends Application
{

  @Override
  public void start(Stage stage) throws Exception {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
    ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
    viewHandler.start();
  }
}
