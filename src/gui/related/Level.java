package gui.related;

import javax.swing.JOptionPane;

import controller.RiverCrossingController;
import controller.interfaces.IRiverCrossingController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class Level {

	protected Sprite[] objects;
	protected GraphicsContext gc;

	protected Canvas canvas = new Canvas(800, 800);

	protected Group root = new Group();

	protected int score = 0;
	protected static Stage stage;

	protected Sprite temp = new Sprite();
	protected int objectNumber = 0;
	protected IRiverCrossingController controller = RiverCrossingController.getInstance();

	protected Button instructions;
	protected Button redo;
	public Button move;
	protected Button exit;
	protected Label scorelabel;
	protected Scene level;
	protected Button undo;

	public Level() {
		instructions = new Button("Instructions");

	}

	public void game() {

		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();

		// redo draw
		redo = new Button("Redo");
		DropShadow redoShadow = new DropShadow();
		redo.setEffect(redoShadow);
		redo.setLayoutY(0);
		redo.setLayoutX(750);

		// redo set on action
		redo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}
		});

		root.getChildren().add(redo);

		// exit drawing
		exit = new Button("Exit");
		exit.setStyle("-fx-font-size: 15pt;");
		exit.setLayoutX(740);
		exit.setLayoutY(450);

		// exit set on action
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controller.saveGame();
				System.exit(0);
			}
		});

		root.getChildren().add(exit);

		// undo drawing
		DropShadow undoShadow = new DropShadow();
		undo = new Button("Undo");
		undo.setEffect(undoShadow);
		undo.setLayoutX(0);
		undo.setLayoutY(0);

		DropShadow instructionsShadow = new DropShadow();

		// insturctions drawing
		instructions.setEffect(instructionsShadow);
		instructions.setStyle("-fx-font-size: 15pt;");
		instructions.setLayoutX(680);
		instructions.setLayoutY(50);

		// instructions set on action must be implemented by child

		instructions.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				JOptionPane.showMessageDialog(null, controller.getInstructions());

			}
		});

		root.getChildren().add(instructions);

		// horizontalBox drawing
		HBox hb = new HBox();
		hb.setSpacing(10);

		hb.getChildren().add(undo);
		/*
		 * if (g instanceof Level1) { objects = Level1.objects; } else if (g instanceof
		 * Level2) { objects = Level2.objects; hb.getChildren().add(Level2.menu); }
		 */

		// -------------------------------------------------

		// ----------------------------------------------------
		root.getChildren().add(hb);
		// scorelabel drawing
		scorelabel = new Label();
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setLayoutX(360);
		scorelabel.setLayoutY(100);

		root.getChildren().add(scorelabel);

		// move drawing
		move = new Button("Move");
		DropShadow moveShadow = new DropShadow();
		move.setEffect(moveShadow);
		move.setStyle("-fx-font-size: 15pt;");
		move.setLayoutX(360);
		move.setLayoutY(150);

		// move set on action must be implemented by each level

		root.getChildren().add(move);

		level = new Scene(root, 800, 800);
		stage.setScene(level);
	}

	public abstract void draw();

	public void updateScoreLabel() {
		scorelabel.setText(Integer.toString(score));
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setText("Score: " + score);
	}

	// codes to look at

	/*
	 * new AnimationTimer() {
	 * 
	 * @Override public void handle(long arg0) { if (g instanceof Level1) {
	 * objectNumber = ((Level1) g).animationSet(gc); objects = Level1.objects; }
	 * else if (g instanceof Level2) { objectNumber = ((Level2) g).animationSet(gc);
	 * objects = Level2.objects; } }
	 * 
	 * }.start(); stage.setScene(level); }
	 */

	/*
	 * level.setOnMousePressed(new EventHandler<MouseEvent>() {
	 * 
	 * @Override public void handle(MouseEvent event) {
	 * temp.setPositionX(event.getX()); temp.setPositionY(event.getY());
	 * 
	 * if (g instanceof Level1) { for (int i = 3; i < 6; i++) { if
	 * (objects.get(i).intersects(temp)) { objectNumber = i; Level1.objectNumber =
	 * objectNumber; Level1.x = objectNumber; } } } else if (g instanceof Level2) {
	 * for (int i = 2; i < 7; i++) { if (objects.get(i).intersects(temp)) {
	 * objectNumber = i; Level2.objectNumber = objectNumber; } } }
	 * 
	 * }
	 * 
	 * });
	 */

	/*
	 * for(int k = 3 ; k< 6 ; k++) { //el mfrod hena azawed condition en ana dost
	 * 3ala wa7ed men el f 50 w 0 w 150 //mesh el 270 da w b3d keda an2el el fo2
	 * tany if(objects.get(k).intersects(temp) && objects.get(k).getPositionX() !=
	 * 270) { for(int i =3 ; i<6 ;i++) { if(objects.get(i).getPositionX() == 270 )
	 * objectNumber = 0; }}} if(objectNumber != 0) { //System.out.println("FU");
	 * if(objects.get(1).getPositionX() == 150) {
	 * objects.get(objectNumber).setPositionX(270);
	 * objects.get(objectNumber).setPositionY(580); objectNumber = 0; }
	 * 
	 * }
	 */

	/*
	 * move.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent arg0) {
	 * 
	 * /* if (g instanceof Level2) { if (Level2.flag) score++;
	 * 
	 * }
	 */

	/*
	 * if (g instanceof Level2) { ((Level2) g).moveOnAction(gc); objects =
	 * Level2.objects; }
	 * 
	 * 
	 * }
	 * 
	 * });
	 */

}
