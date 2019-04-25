package gui.related;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
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
		Button move = new Button("Move");
		move.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		move.setStyle("-fx-font-size: 15pt;");
		VBox vb = new VBox(10);
		vb.setAlignment(Pos.TOP_CENTER);
		vb.getChildren().add(move);
		root.getChildren().add(vb);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Sprite background = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/background.jpg") );
		
		background.render(gc);
		//boat object
		Sprite boat = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/boat.jpg"));
		boat.setPositionX(500);
		boat.setPositionY(600);
		boat.render(gc);
		//-------------------------------
		
		stage.setScene(level1);
		
	}

	public void contGame() {
		// TODO Auto-generated method stub

	}

}
