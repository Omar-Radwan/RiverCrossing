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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import level.Level1Model;

public class IGameLevel {

	IRiverCrossingController controller = RiverCrossingController.getInstance();

	public void selectlevel(String choice, Stage stage) {

		Button newGame = new Button("New game");
		Button loadGame = new Button("Continue");

		newGame.setStyle("-fx-font-size: 15pt;");
		loadGame.setStyle("-fx-font-size: 15pt;");

		newGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (choice.equals("level1")) {
					controller.newGame(new Level1Model());
				} /*
					 * else if (gameLevel instanceof Level2) { Level.stage = stage; ((Level)
					 * gameLevel).game(gameLevel);
					 * 
					 * }
					 */

			}
		});

		loadGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controller.loadGame();
			}
		});

		VBox vb = new VBox(10);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().addAll(newGame, loadGame);
		Image img = new Image("file:src/gui/related/homeground.png");
		BackgroundImage bgImg = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.DEFAULT,
				new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
		vb.setBackground(new Background(bgImg));

		Scene scene = new Scene(vb, 800, 800);
		stage.setScene(scene);

	}

}
