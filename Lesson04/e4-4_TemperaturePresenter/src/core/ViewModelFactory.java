package core;

import view.temperature.TemperatureViewModel;

public class ViewModelFactory
{
  private ModelFactory mf;
  private TemperatureViewModel temperatureVM;

  public ViewModelFactory(ModelFactory mf)
  {
    this.mf = mf;
    temperatureVM = new TemperatureViewModel();
  }

  public TemperatureViewModel getTemperatureVM()
  {
    return temperatureVM;
  }
}
