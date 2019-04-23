import crossers.CrossersFactory;
import crossers.ICrosser;
import crossers.concreteclasses.Farmer;
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
		// TODO Auto-generated method stub
		
		
		
	}

}
