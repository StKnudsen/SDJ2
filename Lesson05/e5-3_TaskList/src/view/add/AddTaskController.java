package view.add;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddTaskController
{
  @FXML private TextField creatorTextField;
  @FXML private TextField descTextField;

  AddTaskViewModel viewModel;
  ViewHandler viewHandler;

  public void init(AddTaskViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  public void onAddButton(ActionEvent evt)
  {

  }

  public void onBackButton(ActionEvent evt)
  {

  }
}
