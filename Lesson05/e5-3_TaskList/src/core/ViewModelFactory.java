package core;

import view.add.AddTaskViewModel;
import view.all.NextTaskViewModel;
import view.remove.AllTaskViewModel;

public class ViewModelFactory
{
  private AddTaskViewModel addTaskViewModel;
  private AllTaskViewModel allTaskViewModel;
  private NextTaskViewModel nextTaskViewModel;

  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    addTaskViewModel = new AddTaskViewModel(modelFactory.getTaskModelManager());
    allTaskViewModel = new AllTaskViewModel(modelFactory.getTaskModelManager());
    nextTaskViewModel = new NextTaskViewModel(modelFactory.getTaskModelManager());
  }

  public AddTaskViewModel getAddTaskViewModel()
  {
    return addTaskViewModel;
  }

  public AllTaskViewModel getAllTaskViewModel()
  {
    return allTaskViewModel;
  }

  public NextTaskViewModel getNextTaskViewModel()
  {
    return nextTaskViewModel;
  }
}
