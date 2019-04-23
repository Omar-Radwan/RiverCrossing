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
		primaryStage.setScene(homeScreen.getScene());
		primaryStage.show();
		
	}

}

/*package gui.related;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class HomeScreen {
	private Stage stage;
	private Scene scene;
	public HomeScreen(Stage stage1) {
		this.stage = stage1;
	}
	private void Homescreen(){
		//ektebi el buttons bta3et level 1 w level 2 wel set on action bta3ha sebih fadi w ana hakamelo w b3d keda 7otihom f scene
		//ba3d keda e3mli stage.setScene(esm el scene da)
		
		
	}
	public Scene getSCene() {
		return scene;
	}

}
*/
