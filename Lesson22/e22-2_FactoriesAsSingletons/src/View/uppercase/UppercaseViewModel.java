package View.uppercase;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.TextConverter;

public class UppercaseViewModel
{
  TextConverter textConverter;
  private StringProperty request, reply, error;

  public UppercaseViewModel(TextConverter textConverter)
  {
    this.textConverter = textConverter;
    request = new SimpleStringProperty("");
    reply = new SimpleStringProperty("");
    error = new SimpleStringProperty("");
  }

  public void convert()
  {
    if(requestProperty().getValue().equals(""))
    {
      error.setValue("Error!");
    }
    else
    {
      reply.set(textConverter.toUppercase(request.getValue()));
      error.setValue("");
    }
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public StringProperty requestProperty()
  {
    return request;
  }

  public StringProperty replyProperty()
  {
    return reply;
  }
}
