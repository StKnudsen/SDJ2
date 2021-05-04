package client.viewmodel;

import client.model.DataModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.Person;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class PersonViewModel
{
  private StringProperty allPersonsProperty;
  private StringProperty firstNameProperty;
  private StringProperty lastNameProperty;
  private StringProperty ageProperty;

  private DataModel model;

  public StringProperty getAllPersonsProperty() {
    return allPersonsProperty;
  }

  public StringProperty getFirstNameProperty() {
    return firstNameProperty;
  }

  public StringProperty getLastNameProperty() {
    return lastNameProperty;
  }

  public StringProperty getAgeProperty() {
    return ageProperty;
  }

  public PersonViewModel(DataModel model) {
    this.model = model;
    allPersonsProperty = new SimpleStringProperty();
    firstNameProperty=new SimpleStringProperty();
    lastNameProperty=new SimpleStringProperty();
    ageProperty=new SimpleStringProperty();
    //((PropertyChangeSubject) model).addPropertyChangeListener(this::onUpdated);
  }

  private String getPersonsAsString() {
    List<Person> persons = model.getPersons();
    String retur = "";
    for (Person person : persons) {
      retur += "\n" + person.getFirstName() + " " + person.getLastName() + " " + person.getAge();
    }
    return retur;
  }
  private void onUpdated(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      allPersonsProperty.setValue(getPersonsAsString());
    });
  }

  public void savePerson() {
    model.addPerson(new Person(firstNameProperty.get(), lastNameProperty.get(), Integer.parseInt(ageProperty.get())));
  }
  public void showPersons() {
    onUpdated(null);
  }
}
