package core;

import mediator.TemperatureModel;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public TemperatureModel getTemperatureModel()
  {
    return temperatureModel;
  }
}
