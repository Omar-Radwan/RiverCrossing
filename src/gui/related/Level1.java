package gui.related;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Level1 extends IGameLevel {
	private Stage stage;
	//private Image [] image = new Image[6];
	public Level1() {

	}

	public Level1(Stage stage1) {
		stage = stage1;
	}

	public void makeNewGame() {
		Group root = new Group();
		Scene level1 = new Scene(root , 800 , 800);
		Canvas canvas = new Canvas(800 , 800);
		root.getChildren().add(canvas);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Sprite background = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/background.jpg") );
		
		background.render(gc);
		//boat object
		Sprite boat = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/boat.jpg"));
		boat.setPositionX(500);
		boat.setPositionY(600);
		boat.render(gc);
		stage.setScene(level1);
		
	}

	public void contGame() {
		// TODO Auto-generated method stub

	}

}
