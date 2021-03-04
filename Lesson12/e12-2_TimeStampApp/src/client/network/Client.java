package client.network;

import shared.PropertyChangeSubject;

import java.util.Date;

public interface Client extends PropertyChangeSubject
{
  String getLastUpdateTimeStamp();

  int getNumberOfUpdates();

  void setTimeStamp(Date timeStamp);

  void startClient();
}
