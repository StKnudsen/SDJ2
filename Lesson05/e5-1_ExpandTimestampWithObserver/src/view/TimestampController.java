package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import viewmodel.TimestampViewModel;

import java.beans.PropertyChangeEvent;
//import viewmodel.ViewModelFactory;

public class TimestampController {

    @FXML Label eventLabel;
    @FXML Label numberOfUpdates;
    @FXML TextField colourField;

    private TimestampViewModel viewModel;

    public TimestampController() {
    }

    public void init(TimestampViewModel viewModel) {
        this.viewModel = viewModel;

        eventLabel.textProperty().bind(viewModel.updateTimeStampProperty());
        numberOfUpdates.textProperty().bind(viewModel.numberOfUpdatesProperty());
        colourField.backgroundProperty().bind(viewModel.colourFieldProperty());

    }

    public void onUpdateButton(ActionEvent actionEvent) {
        viewModel.propertyChange(new PropertyChangeEvent(this, "Updated", 0 , 1));
    }
}
