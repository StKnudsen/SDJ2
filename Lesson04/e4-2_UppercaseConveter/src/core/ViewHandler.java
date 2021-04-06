package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.uppercase.UppercaseViewController;

import java.io.IOException;

public class ViewHandler
{
  Scene scene;
  Stage stage;
  ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    stage = new Stage();
  }

  public void start() throws IOException
  {
    openToUppercase();
  }

  private void openToUppercase() throws IOException
  {
    if(scene == null)
    {
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("../view/uppercase/UppercaseView.fxml"));
      Parent root = loader.load();

      UppercaseViewController controller = loader.getController();
      controller.init(viewModelFactory.getUppercaseVM());

      stage.setTitle("Upper case");
      scene = new Scene(root);
    }
      stage.setScene(scene);
      stage.show();
  }
}
