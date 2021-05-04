package client.view;

import client.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(Stage stage, ViewModelFactory viewModelFactory) {
    this.stage = stage;
    this.viewModelFactory = viewModelFactory;
  }

  public void start() throws Exception{
    openView("Person");
  }

  public void openView(String viewToOpen) throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;

    loader.setLocation(getClass().getResource(viewToOpen +"View.fxml"));
    root = loader.load();
    if("Person".equals(viewToOpen)) {
      PersonController view = loader.getController();
      view.init(viewModelFactory.getTimestampViewModel());
      stage.setTitle("Persons");
    }

    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
