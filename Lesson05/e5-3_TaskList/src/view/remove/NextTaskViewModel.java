package view.remove;

import javafx.beans.property.StringProperty;
import model.TaskModel;

public class NextTaskViewModel
{
  private StringProperty description;
  private StringProperty creator;
  private StringProperty date;

  private TaskModel taskModel;

  public NextTaskViewModel(TaskModel taskModel)
  {
    this.taskModel = taskModel;
  }

  public void getNextTask()
  {
    //
  }

  public void clearDate()
  {
    //
  }

  public StringProperty descriptionProperty()
  {
    return description;
  }

  public StringProperty creatorProperty()
  {
    return creator;
  }

  public StringProperty dateProperty()
  {
    return date;
  }
}
