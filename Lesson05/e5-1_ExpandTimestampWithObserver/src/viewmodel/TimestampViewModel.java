package viewmodel;

import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import model.DataModel;
import model.PropertyChangeSubject;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeSupport;

public class TimestampViewModel {

    //private final Object BackgroundFill;
    private StringProperty updateTimeStamp;

    private StringProperty numberOfUpdates;

    private ObjectProperty colourField;

    private DataModel model;

    public TimestampViewModel(DataModel model) {
        this.model = model;
        updateTimeStamp = new SimpleStringProperty("Last update: ");
        numberOfUpdates = new SimpleStringProperty("0");
        colourField = new SimpleObjectProperty(new Background(new BackgroundFill(
            Color.valueOf("red"), CornerRadii.EMPTY , Insets.EMPTY)));
        ((PropertyChangeSubject) model).addPropertyChangeListener((PropertyChangeEvent evt) -> this.propertyChange(evt));
    }


    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("Updated"))
        {
            model.increaseNumberOfUpdates();
            Platform.runLater(() -> {
                updateTimeStamp.setValue("Last updated: " + model.getLastUpdateTimeStamp());
                numberOfUpdates.setValue("Number of updates:" + model.getNumberOfUpdates());
            });
        }
        else
        {
            colourField.setValue(new Background(new BackgroundFill(
                Color.valueOf((String) evt.getNewValue()), CornerRadii.EMPTY , Insets.EMPTY)));
        }
    }

    public StringProperty updateTimeStampProperty() {
        return updateTimeStamp;
    }

    public StringProperty numberOfUpdatesProperty() {
        return numberOfUpdates;
    }

    public ObjectProperty<Background> colourFieldProperty()
    {
        return colourField;
    }
}
