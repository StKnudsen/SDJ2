package core;

import View.uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  static ViewHandler instance;

  private ViewHandler()
  {
    //this.viewModelFactory = ViewModelFactory.getInstance();
    stage = new Stage();
  }

  public static ViewHandler getInstance()
  {
    if (instance == null)
    {
      instance = new ViewHandler();
    }

    return instance;
  }

  Scene scene;
  Stage stage;
  //ViewModelFactory viewModelFactory;

  //public ViewHandler(ViewModelFactory viewModelFactory)
  //{
  //  this.viewModelFactory = viewModelFactory;
  //  stage = new Stage();
  //}

  public void start() throws IOException
  {
    openToUppercase();
  }

  private void openToUppercase() throws IOException
  {
    if (scene == null)
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(
          getClass().getResource("../view/uppercase/UppercaseView.fxml"));
      Parent root = loader.load();

      UppercaseViewController controller = loader.getController();
      controller.init(ViewModelFactory.getInstance().getUppercaseVM());

      stage.setTitle("Upper case");
      scene = new Scene(root);
    }
    stage.setScene(scene);
    stage.show();
  }
}
