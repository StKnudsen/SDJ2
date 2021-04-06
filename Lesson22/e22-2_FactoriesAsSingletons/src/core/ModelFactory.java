package core;

import model.TextConverter;
import model.TextConverterModel;

public class ModelFactory
{
  static ModelFactory instance;

  public static ModelFactory getInstance()
  {
    if (instance == null)
    {
      instance = new ModelFactory();
    }
    return instance;
  }

  TextConverter textConverter;

  private ModelFactory()
  {
  }

  public TextConverter getTextConverter()
  {
    if(textConverter == null)
    {
      textConverter = new TextConverterModel();
    }

    return textConverter;
  }
}
