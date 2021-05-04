package client.view;

import client.viewmodel.PersonViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PersonController
{
  @FXML
  private TextField firstName;

  @FXML
  private TextField lastName;

  @FXML
  private TextField age;

  @FXML
  private Button saveButton;

  @FXML
  private Button showPersonsButton;

  @FXML
  private TextArea allPersons;


  private PersonViewModel viewModel;

  public PersonController() {
  }

  public void init(PersonViewModel viewModel) {
    this.viewModel = viewModel;

    allPersons.textProperty().bind(viewModel.getAllPersonsProperty());
    firstName.textProperty().bindBidirectional(viewModel.getFirstNameProperty());
    lastName.textProperty().bindBidirectional(viewModel.getLastNameProperty());
    age.textProperty().bindBidirectional(viewModel.getAgeProperty());
  }

  public void onSaveButton(ActionEvent actionEvent) {
    viewModel.savePerson();
  }

  public void onShowButton(ActionEvent actionEvent) {
    viewModel.showPersons();
  }
}
