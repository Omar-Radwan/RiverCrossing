package gui.related;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.RiverCrossingController;
import controller.interfaces.IRiverCrossingController;
import crossers.interfaces.ICrosser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
	protected Button reset;
	int[] rightX;
	int[] rightY;

	int[] leftX;
	int[] leftY;

	int[] boatX = {};
	int[] boatY = {};

	public Level() {
		instructions = new Button("Instructions");

	}

	private void setStyle(Button button) {
		button.setStyle(" -fx-background-color: \n" + "        #ecebe9,\n" + "        rgba(0,0,0,0.05),\n"
				+ "        linear-gradient(#dcca8a, #c7a740),\n"
				+ "        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n"
				+ "        linear-gradient(#f6ebbe, #e6c34d);\n" + "    -fx-background-insets: 0,9 9 8 9,9,10,11;\n"
				+ "    -fx-background-radius: 50;\n" + "    -fx-padding: 15 30 15 30;\n"
				+ "    -fx-font-family: \"Times New Roman\";\n" + "    -fx-font-size: 10px;\n"
				+ "    -fx-text-fill: #311c09;\n"
				+ "    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

	}

	public void doTheCommonThingsInAllLevels() {

		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		//reset 
		reset = new Button("reset");
		setStyle(reset);
		reset.setLayoutX(0);
		reset.setLayoutY(100);
		root.getChildren().add(reset);
		reset.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				controller.resetGame();
				
			}
		});
		// redo draw
		redo = new Button("Redo");
		setStyle(redo);
		// DropShadow redoShadow = new DropShadow();
		// redo.setEffect(redoShadow);
		redo.setLayoutY(0);
		redo.setLayoutX(720);

		// redo set on action
		redo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				if (controller.canRedo()) {
					System.out.println("Left: " + controller.getCrosserOnLeftBank());
					System.out.println("Right: " + controller.getCrossersOnRightBank());

					controller.redo();
					System.out.println("left: " + controller.getCrosserOnLeftBank());
					System.out.println("Right: " + controller.getCrossersOnRightBank());

				}
			}
		});

		root.getChildren().add(redo);

		// exit drawing
		exit = new Button("Exit");
		setStyle(exit);
		// exit.setStyle("-fx-font-size: 15pt;");
		exit.setLayoutX(720);
		exit.setLayoutY(660);

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
		// DropShadow undoShadow = new DropShadow();
		//HBox hb = new HBox();
		//hb.setSpacing(10);
		undo = new Button("Undo");
		
		// undo.setEffect(undoShadow);
		setStyle(undo);
		//undo.setLayoutX(0);
		//undo.setLayoutY(20);
		//hb.getChildren().addAll(undo , Level2.menu);
	//	root.getChildren().add(hb);
		undo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (controller.canUndo()) {
					System.out.println("Left: " + controller.getCrosserOnLeftBank());
					System.out.println("Right: " + controller.getCrossersOnRightBank());

					controller.undo();

					System.out.println(controller.getNumberOfSails());
					System.out.println("left: " + controller.getCrosserOnLeftBank());
					System.out.println("Right: " + controller.getCrossersOnRightBank());

				}

			}
		});
		// insturctions drawing
		// DropShadow instructionsShadow = new DropShadow();
		// instructions.setEffect(instructionsShadow);
		setStyle(instructions);
		// instructions.setStyle("-fx-font-size: 15pt;");
		instructions.setLayoutX(693);
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
		hb.getChildren().add(Level2.menu);
		
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
		// DropShadow moveShadow = new DropShadow();
		// move.setEffect(moveShadow);
		setStyle(move);
		// move.setStyle("-fx-font-size: 15pt;");
		move.setLayoutX(360);
		move.setLayoutY(150);

		// move set on action must be implemented by each level

		root.getChildren().add(move);

		level = new Scene(root, 800, 800);

		renderObjects();

		stage.setScene(level);
	}

	// abstract method 3shan kol level lazm y7aded hwa hitrasam ezay
	public abstract void draw();

	public void updateScoreLabel() {
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setText("Score: " + controller.getNumberOfSails());
	}

	// bt render kol al objects al mwgoda
	public void renderObjects() {
		for (int i = 0; i < objects.length; i++) {
			objects[i].render(gc);
		}
	}

	// bt update w t redner kol al objects
	public void updateAndRender() {
		for (int i = 0; i < objects.length; i++) {
			objects[i].update();
			objects[i].render(gc);
		}
	}

	// bt set al positon bta3 al boat 3la 7asab hwa mgod ymen wla shmal
	public void setBoatPosition() {

		if (controller.isBoatOnTheLeftBank()) {
			objects[1].setPositionX(leftX[1]);
			objects[1].setPositionY(leftY[1]);
		} else {
			objects[1].setPositionX(rightX[1]);
			objects[1].setPositionY(rightY[1]);
		}
	}

	// btgeb al crosser al index bta3o n f objects .. di m3mola 3shan nst5ha f
	// buildCrossersOnBoat()
	public ICrosser getCrosserWithNumber(int n) {
		for (ICrosser x : controller.getCrosserOnLeftBank()) {
			if (x.getNumber() == n) {
				return x;
			}
		}

		for (ICrosser x : controller.getCrossersOnRightBank()) {
			if (x.getNumber() == n) {
				return x;
			}
		}
		return null;
	}

	// btshoof men al crossers al mwgoden 3la al boat dlw2ty w t3ml list of crossers
	// bihom 3shan nb3tha llcontroller.
	public List<ICrosser> buildCrossersOnBoat() {
		List<ICrosser> crossersOnBoat = new LinkedList<ICrosser>();

		for (int i = 2; i < objects.length; i++) {
			if (objects[i].intersects(objects[1])) {
				crossersOnBoat.add(getCrosserWithNumber(i));
			}
		}

		return crossersOnBoat;

	}

	public abstract void setCrossersPositionsAndImages();

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
