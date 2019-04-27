import java.io.IOException;

import crossers.ICrossersFactory;
import crossers.abstractclasses.CrosserAC;
import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;
import gui.related.HomeScreen;
//import gui.related.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import level.ICrossingStrategy;
import level.Level1;
import xmlfiles.XReader;
import xmlfiles.XWriter;
import xmlparsers.XmlFilesReader;
import xmlparsers.XmlFilesWriter;

public class Main extends Application {

	public static void main(String[] args) throws IOException {

		ICrossersFactory iCrossersFactory = ICrossersFactory.getInstance();
		CrosserAC.setICrosserFactory(iCrossersFactory);
		
		
		
		
		
		//launch(args);

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
