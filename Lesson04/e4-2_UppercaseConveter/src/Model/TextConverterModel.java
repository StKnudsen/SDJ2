package Model;

import java.util.Locale;

public class TextConverterModel implements TextConverter
{


  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }
}
