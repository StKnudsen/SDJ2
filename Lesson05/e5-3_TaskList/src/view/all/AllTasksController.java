package view.all;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Task;

public class AllTasksController
{
  @FXML private TableColumn<String, Task> descriptionColumn;
  @FXML private TableColumn<String, Task> creatorColumn;
  @FXML private TableColumn<String, Task> dateColumn;
  @FXML private TableView<Task> tableView;

  private AllTaskViewModel viewModel;
  private ViewHandler viewHandler;

  public void init(AllTaskViewModel viewModel, ViewHandler viewHandler)
  {
    this.viewModel = viewModel;
    this.viewHandler = viewHandler;

    tableView.setItems(viewModel.getTasks());

    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
  }

  public void openAddTaskView(ActionEvent actionEvent)
  {
    viewModel.openAddTaskView();
  }

  public void openNextTaskView(ActionEvent actionEvent)
  {
    viewModel.openNextTaskView();
  }
}
