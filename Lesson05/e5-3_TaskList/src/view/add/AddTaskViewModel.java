package view.add;

import javafx.beans.property.StringProperty;
import model.TaskModel;

public class AddTaskViewModel
{
  private StringProperty creator;
  private StringProperty description;
  private TaskModel model;

  public AddTaskViewModel(TaskModel model)
  {
    this.model = model;
  }


}
