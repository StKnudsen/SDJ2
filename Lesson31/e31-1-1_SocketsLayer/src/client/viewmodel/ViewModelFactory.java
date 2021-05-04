package client.viewmodel;

import client.model.ModelFactory;

public class ViewModelFactory
{
  private PersonViewModel timestampViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    timestampViewModel = new PersonViewModel(modelFactory.getDataModel());
  }

  public PersonViewModel getTimestampViewModel() {
    return timestampViewModel;
  }
}
