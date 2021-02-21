package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataModelManager implements DataModel, PropertyChangeSubject {

    private String lastUpdate;
    private int numberOfUpdates;
    private PropertyChangeSupport propertyChangeSupport;
    private int counter;

    public DataModelManager() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public String getLastUpdateTimeStamp() {
        return lastUpdate;
    }

    @Override
    public void increaseNumberOfUpdates() {
        numberOfUpdates++;
    }

    @Override
    public int getNumberOfUpdates() {
        return numberOfUpdates;
    }

    public void recalculateData() {
        String last = lastUpdate;
        calcTimeStamp();
        propertyChangeSupport.firePropertyChange("Updated", last, lastUpdate);

        counter++;
        if (counter%10 == 0)
        {
            if ((counter/10)%2 == 0)
            {
                propertyChangeSupport.firePropertyChange("Colour", 1, "red");
            }
            else
            {
                propertyChangeSupport.firePropertyChange("Colour", 1, "green");
            }
        }
    }

    private void calcTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("HH:mm:ss");
        Date now = new Date();
        String strDate = sdfDate.format(now);
        System.out.println(strDate);
        lastUpdate = strDate;
    }

    @Override
    public void addPropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(name, listener);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String name, PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(name, listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
