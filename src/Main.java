import crossers.CrossersFactory;
import crossers.ICrosser;
import crossers.concreteclasses.Farmer;
import gui.related.HomeScreen;
//import gui.related.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {

		CrossersFactory crossersFactory = new CrossersFactory();
		
		ICrosser f1 = crossersFactory.getCrosser("farmer");

		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HomeScreen homeScreen = new HomeScreen(primaryStage);
		primaryStage.setTitle("River crossing");
		homeScreen.Homescreen();
		//primaryStage.setScene(homeScreen.getScene());
		primaryStage.show();
		
		
		
	}

}
