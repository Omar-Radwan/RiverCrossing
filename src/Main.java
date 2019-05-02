import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import controller.RiverCrossingController;
import controller.interfaces.IRiverCrossingController;
import crossers.BufferedImagesGetter;
import crossers.ICrossersFactory;
import crossers.abstractclasses.CrosserAC;
import gui.related.HomeScreen;
//import gui.related.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import level.Level1Model;

public class Main extends Application {

	public static void main(String[] args) throws IOException, ParserConfigurationException {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HomeScreen homeScreen = new HomeScreen(primaryStage);
		primaryStage.setTitle("River crossing");
		homeScreen.Homescreen();
		// primaryStage.setScene(homeScreen.getScene());
		primaryStage.show();

	}

}
