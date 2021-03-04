package model;

import client.model.ClientFactory;

public class ModelFactory {

    private DataModel dataModel;

    public DataModel getDataModel() {
        if(dataModel == null) {
            dataModel = new DataModelManager(ClientFactory.getInstance().getClient());
        }
        return dataModel;
    }


}
