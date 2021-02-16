package core;

import view.uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  ModelFactory modelFactory;
  UppercaseViewModel uppercaseVM;

  public ViewModelFactory(ModelFactory mf)
  {
    modelFactory = mf;
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
