package core;

import View.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  static ViewModelFactory instance;

  public static ViewModelFactory getInstance()
  {
    if (instance == null)
    {
      instance = new ViewModelFactory();
    }
    return instance;
  }

  ModelFactory modelFactory;
  UppercaseViewModel uppercaseVM;

  private ViewModelFactory()
  {
    modelFactory = ModelFactory.getInstance();
  }

  public UppercaseViewModel getUppercaseVM()
  {
    if(uppercaseVM == null)
    {
      uppercaseVM = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return uppercaseVM;
  }
}
