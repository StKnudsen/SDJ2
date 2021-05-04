package client.model;

import client.network.ClientFactory;

public class ModelFactory
{
  private DataModel dataModel;
  ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory) {
    this.clientFactory = clientFactory;
  }

  public DataModel getDataModel() {
    if(dataModel == null) {
      dataModel = new DataModelManager(clientFactory.getClient());
    }
    return dataModel;
  }

}
