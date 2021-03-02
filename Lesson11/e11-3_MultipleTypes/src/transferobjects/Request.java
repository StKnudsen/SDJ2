package transferobjects;

import java.io.Serializable;

public class Request implements Serializable
{
  private RequestType requestType;
  private String arguments;

  public Request(String arguments, RequestType requestType)
  {
    this.requestType = requestType;
    this.arguments = arguments;
  }

  public String getArguments()
  {
    return arguments;
  }

  public RequestType getRequestType()
  {
    return requestType;
  }

  public enum RequestType
  {
    UpperCase,
    LowerCase
  }
}
