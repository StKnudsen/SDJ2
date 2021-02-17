package view.remove;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Task;

public class AllTasksController
{
  @FXML private TableView<Task> tableView;
  @FXML private TableColumn<String, Task> creatorColumn;
  @FXML private TableColumn<String, Task> descColumn;
  @FXML private TableColumn<String, Task> dateColumn;

  private AllTaskViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(AllTaskViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;
  }

  public void onAddButton(ActionEvent evt)
  {

  }

  public void onNextTaskButton(ActionEvent evt)
  {

  }
}
