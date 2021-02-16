package view.temperature;

import core.ViewHandler;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import mediator.TemperatureModel;
import model.Temperature;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TemperatureViewController implements PropertyChangeListener
{
   @FXML private Label outputLabel;
   @FXML private TextField filterField;
   @FXML private Label filterLabel;
   private ViewHandler viewHandler;
   private TemperatureViewModel viewModel;

   //private TemperatureModel model;
   private Region root;
   private String thermometerId;
   //private boolean hasListener;

   private PropertyChangeSupport propertyChangeSupport;

   public TemperatureViewController()
   {
   }

   public void init(ViewHandler viewHandler, TemperatureViewModel viewModel, Region root)
   {
      this.viewHandler = viewHandler;
      this.viewModel = viewModel;
      this.root = root;
      thermometerId = null;
      //hasListener = false;
   }

   public void reset()
   {
      // empty
   }

   public Region getRoot()
   {
      return root;
   }

   @FXML private void updateButtonPressed()
   {
      viewModel.getValue();
      /*if (hasListener)
      {
         //model.removeListener("AddTemperature", this);
         viewModel.removeListener("AddTemperature", this);
         hasListener = false;
      }
      else
      {
         //model.addListener("AddTemperature", this);
         viewModel.addListener("AddTemperature", this);
         hasListener = true;
      }*/
   }

   @FXML private void onFilter()
   {
      viewModel.updateThermometerId();

      /*String oldValue = filterLabel.getText();
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
      filterField.setText(null);*/
      updateButtonPressed();
   }

   @Override public void propertyChange(PropertyChangeEvent evt)
   {
      Platform.runLater(() -> {
         //Temperature t = model.getLastInsertedTemperature(thermometerId);
         Temperature t = viewModel.getLastInsertedTemperature(thermometerId);
         if (t != null)
         {
            outputLabel.setText(t.toString());
         }
         else
         {
            outputLabel.setText("No data");
         }
      });
   }
}
