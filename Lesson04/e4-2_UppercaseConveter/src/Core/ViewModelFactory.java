package Core;

import View.Uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  UppercaseViewModel uppercaseViewModel;
  ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    uppercaseViewModel = new UppercaseViewModel();
  }

  public UppercaseViewModel getUppercaseVM()
  {
    return uppercaseViewModel;
  }
}
