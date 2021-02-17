package view.all;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import view.add.AddTaskViewModel;

public class NextTaskController
{
  @FXML private Label descLabel;
  @FXML private Label creatorLabel;
  @FXML private Label timeLabel;

  NextTaskViewModel viewModel;
  ViewHandler viewHandler;

  public void init(NextTaskViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  public void onGetTaskButton(ActionEvent evt)
  {

  }

  public void onBackButton(ActionEvent evt)
  {

  }
}
