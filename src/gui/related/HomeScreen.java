package gui.related;

import controller.RiverCrossingController;
import controller.interfaces.IRiverCrossingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import level.Level1Model;
import level.Level2Model;

public class HomeScreen {
//private Image image;
	private Stage stage;
	private Scene scenehomescreen;

	private IGameLevel gameLevel;
	private IRiverCrossingController controller;

	public HomeScreen(Stage stage1) {
		this.stage = stage1;
		controller = RiverCrossingController.getInstance();
	}

	public void Homescreen() {
		Level.stage = stage;

		VBox label = new VBox();
		HBox buttons = new HBox(10);
		Button level1 = new Button("Level 1");
		level1.setStyle("-fx-font-size: 15pt;");

		level1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				gameLevel = new IGameLevel();
				gameLevel.selectlevel("level1", stage);
				controller.setStrategy(new Level1Model());


			}
		});

		Button level2 = new Button("Level 2");
		level2.setStyle("-fx-font-size: 15pt;");

		buttons.setAlignment(Pos.CENTER);
		
		  level2.setOnAction(new EventHandler<ActionEvent>() {
		  
		  @Override public void handle(ActionEvent e) {
		  
		  gameLevel = new IGameLevel();
		  gameLevel.selectlevel("level2", stage);
		  controller.setStrategy(new Level2Model());
		  } });
		 
		buttons.getChildren().addAll(level1, level2);
		GridPane grid = new GridPane();
		Button exit = new Button("Exit");
		grid.setAlignment(Pos.CENTER);
		grid.add(exit, 10, 10);
		exit.setStyle("-fx-font-size: 15pt;");

		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		VBox vb = new VBox(10);
		vb.getChildren().addAll(label, buttons, grid);

		Image img = new Image("file:src/gui/related/homeground.png");

		BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

		vb.setBackground(new Background(bgImg));

		scenehomescreen = new Scene(vb, 800, 800);

		stage.setScene(scenehomescreen);

	}

}