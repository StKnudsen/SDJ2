package core;

import model.TextConverter;
import model.TextConverterModel;

public class ModelFactory
{
  TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if(textConverter == null)
    {
      textConverter = new TextConverterModel();
    }
    return textConverter;
  }
}
