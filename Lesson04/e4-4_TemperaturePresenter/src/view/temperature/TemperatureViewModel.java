package view.temperature;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;

public class TemperatureViewModel
{
  private DoubleProperty temperature;
  private StringProperty id;
  private TemperatureModel model;
  private boolean hasListener = false;

  public TemperatureViewModel(TemperatureModel model)
  {
    this.model = model;
    id = new SimpleStringProperty();
    temperature = new SimpleDoubleProperty();
  }

  public void getLastTemp()
  {
    model.getLastInsertedTemperature(id.getValue());
  }

  public void getValue()
  {
    if (hasListener)
    {
      model.removeListener("AddTemperature", this);
      hasListener = false;
    }
    else
    {
      model.addListener("AddTemperature", this);
      hasListener = true;
    }
  }

  public void updateThermometerId()
  {
    String oldValue = filterLabel.getText();
    if (oldValue.equals("All"))
    {
      oldValue = null;
    }
    thermometerId = filterField.getText();
    if (thermometerId == null || thermometerId.isEmpty()) // Updated this line, see Itslearning.
    {
      thermometerId = null;
      filterLabel.setText("All");
    }
    else
    {
      filterLabel.setText(thermometerId);
    }
    filterField.setText(null);
  }
}
