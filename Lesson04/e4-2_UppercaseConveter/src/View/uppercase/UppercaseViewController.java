package View.uppercase;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UppercaseViewController
{
  @FXML TextField requestField;
  @FXML TextField replyField;
  @FXML Label errorLabel;

  UppercaseViewModel uppercaseViewModel;

  public void init(UppercaseViewModel viewModel)
  {
    replyField.setDisable(true);
    uppercaseViewModel = viewModel;
    requestField.textProperty().bindBidirectional(viewModel.requestProperty());
    replyField.textProperty().bind(viewModel.replyProperty());
    errorLabel.textProperty().bind(viewModel.errorProperty());
  }

  public void onSubmitButton(ActionEvent actionEvent)
  {
    uppercaseViewModel.convert();
  }
}
