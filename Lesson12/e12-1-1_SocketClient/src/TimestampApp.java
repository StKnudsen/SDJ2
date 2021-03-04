import javafx.application.Application;
import javafx.stage.Stage;
import model.DataModelManager;
import model.ModelFactory;
import view.ViewHandler;
import viewmodel.ViewModelFactory;

import java.util.Random;


@SuppressWarnings("ALL")
public class TimestampApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        ModelFactory mf = new ModelFactory();
        ViewModelFactory viewModelFactory = new ViewModelFactory(mf);
        ViewHandler viewHandler = new ViewHandler(stage, viewModelFactory);
        viewHandler.start();

    }

}
