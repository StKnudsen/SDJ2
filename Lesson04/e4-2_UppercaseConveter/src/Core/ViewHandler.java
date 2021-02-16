package Core;

import javafx.scene.Scene;

public class ViewHandler
{
  private Scene uppercaseScene;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    //this.uppercaseScene = new Scene();
  }
}
