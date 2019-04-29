package gui.related;

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

public abstract class IGameLevel extends Level {

	// Level level;
	public void selectlevel(Object gameLevel, Stage stage) {
		Button newGame = new Button("New game");
		Button loadGame = new Button("Continue");
		newGame.setStyle("-fx-font-size: 15pt;");
		loadGame.setStyle("-fx-font-size: 15pt;");

		newGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (gameLevel instanceof Level1) {
					Level.stage = stage;
					((Level) gameLevel).game(gameLevel);
				} else if (gameLevel instanceof Level2) {
					Level.stage = stage;
					((Level) gameLevel).game(gameLevel);

				}

			}
		});
		loadGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

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

	// ha3mel beha new game
	public abstract void makeNewGame();

	// ha3mel beha continue lel game fa lazem a2ra mel file
	public abstract void contGame();

}
