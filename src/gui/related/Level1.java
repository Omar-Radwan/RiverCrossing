package gui.related;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Level1 extends IGameLevel {
	private Stage stage;
	private Sprite[] objects = new Sprite[6];
	Sprite temp = new Sprite();

	// private Image [] image = new Image[6];
	public Level1() {

	}

	public Level1(Stage stage1) {
		stage = stage1;
	}

	int objectNumber = 0;

	public void makeNewGame() {
		double posX = 0.0;
		double posY = 0.0;

		Group root = new Group();
		Canvas canvas = new Canvas(800, 800);
		root.getChildren().add(canvas);

		GraphicsContext gc = canvas.getGraphicsContext2D();
		// object background
		objects[0] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/background.jpg"));

		objects[0].render(gc);
		// -------------------------------------

		// boat object
		objects[1] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/boat.jpg"));
		objects[1].setPositionX(500);
		objects[1].setPositionY(600);
		objects[1].render(gc);
		// -------------------------------
		// farmer object
		objects[2] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/farmer.png"));
		objects[2].setPositionX(520);
		objects[2].setPositionY(570);
		objects[2].render(gc);
		// --------------------------------------
		// plant object
		objects[3] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/plant.png"));
		objects[3].setPositionX(580);
		objects[3].setPositionY(510);
		objects[3].render(gc);
		// --------------------------------------------
		// carni animal
		// el mafrod ha3mel random ya3ni bas lesa ama agib animal tany
		// ha3mel rand we law 0 yeb2a el object da lion
		// law 1 haykon el object da wolf same will go with herbi
		objects[4] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/lion.png"));
		objects[4].setPositionX(650);
		objects[4].setPositionY(530);
		objects[4].render(gc);

		// ----------------------------------------------
		// herbi
		objects[5] = new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/sheep.png"));
		objects[5].setPositionX(730);
		objects[5].setPositionY(530);
		objects[5].render(gc);
		// ---------------------------------------------
		// animation button :
		/*
		 * new AnimationTimer() {
		 * 
		 * @Override public void handle(long arg0) { objects[1].addDeltaX(300);
		 * objects[2].addDeltaX(-300); for(int i =0 ; i<6 ; i++) { objects[i].update();
		 * objects[i].render(gc); }
		 * 
		 * } };
		 */
		// --------------------------------------------
		// button move :
		Button move = new Button("Move");
		move.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				objects[1].addDeltaX(-350);
				objects[2].addDeltaX(-350);
				for (int j = 3; j < 6; j++) {
					if (objects[j].intersects(objects[1])) {
						objects[j].addDeltaX(-350);
					}
					for (int i = 0; i < 6; i++) {
						objects[i].update();
						objects[i].render(gc);
					}
				}

			}
		});
		move.setStyle("-fx-font-size: 15pt;");
		VBox vb = new VBox(10);
		vb.setAlignment(Pos.CENTER);
		vb.getChildren().add(move);
		root.getChildren().add(vb);

		Scene level1 = new Scene(root, 800, 800);
		level1.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				// TODO Auto-generated method stub
				temp.setPositionX(event.getX());
				temp.setPositionY(event.getY());
				for (int i = 3; i < 6; i++) {
					if (objects[i].intersects(temp)) {
						objectNumber = i;

					}
				}
				// System.out.println("X: " + event.getX() + " Y: " + event.getY());
			}
		});
		// if(objectNumber != 0) {
		// System.out.println("Hello");
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				if (objectNumber != 0) {
					objects[objectNumber].setPositionX(620);
					objects[objectNumber].setPositionY(600);
					objectNumber = 0;
					for (int i = 0; i < 6; i++) {
						objects[i].update();
						objects[i].render(gc);
					}

				}
			}
		}.start();
		// }
		stage.setScene(level1);

	}

	public void contGame() {
		// TODO Auto-generated method stub

	}

}
