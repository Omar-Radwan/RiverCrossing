package gui.related;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Level1 extends IGameLevel {
	private Stage stage;
	//private Sprite[] objects = new Sprite[6];
	//Sprite temp = new Sprite();
	//private int score=0;
	static int objectNumber = 0;
	static ArrayList<Sprite> objects = new ArrayList<Sprite>();
	private Random rand = new Random();
	// private Image [] image = new Image[6];
	public Level1() {
		int ran1 = rand.nextInt(1);
		int ran2 = rand.nextInt(1);
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/background.jpg" ) ));
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/boat.jpg")));
		objects.add( new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/farmer.png")));
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/plant.png")));
		//if(ran1 == 0)
			objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/lion.png")));
		//else
			//hagib wolf bas not now w y add it here 
		//if (ran2 == 0)
			objects.add( new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/sheep.png")));
		//else
			// hagib b2a el goat			
		objects.get(1).setPositionX(500);
		objects.get(1).setPositionY(600);
		objects.get(2).setPositionX(520);
		objects.get(2).setPositionY(570);
		objects.get(3).setPositionX(580);
		objects.get(3).setPositionY(510);
		objects.get(4).setPositionX(650);
		objects.get(4).setPositionY(530);
		objects.get(5).setPositionX(730);
		objects.get(5).setPositionY(530);
		
		
	}
	
	/*public Level1(Stage stage1) {
		stage = stage1;
	}*/
	public void moveOnAction(GraphicsContext gc) {
		if(objects.get(1).getPositionX() == 500){
			objects.get(1).addDeltaX(-350);
			objects.get(2).addDeltaX(-350);
			for (int j = 3; j < 6; j++) {
				if (objects.get(j).intersects( objects.get(1) )) {
					objects.get(j).addDeltaX(-350);
				}
			}
				for (int i = 0; i < 6; i++) {
					objects.get(i).update();
					objects.get(i).render(gc);
				}
		}
			else {
				objects.get(1).addDeltaX(350);
				objects.get(2).addDeltaX(350);
				for (int j = 3; j < 6; j++) {
					if (objects.get(j).intersects(objects.get(1))) {
						objects.get(j).addDeltaX(350);
					}
				}
					for (int i = 0; i < 6; i++) {
						objects.get(i).update();
						objects.get(i).render(gc);
					}
			}
	}
	public int animationSet(GraphicsContext gc) {
		if(objects.get(1).getPositionX() == 500)
		{	for(int k =3 ;k<6; k++) {
			if(objects.get(k).getPositionX() == 620)
				objectNumber = 0;
			//new position is 270
		}
		if (objectNumber != 0 ) {
			if(objects.get(1).getPositionX() == 500) {
			objects.get(objectNumber).setPositionX(620);
			objects.get(objectNumber).setPositionY(580);
			objectNumber = 0;
			}
			else if(objects.get(objectNumber).intersects(objects.get(1))){
				boolean flag1 = false;
				boolean flag2 = false;
				for(int l =3 ; l<6 ; l++) {
					if(objects.get(l).getPositionX() == 50) {
						flag1 = true;
					}
					else if (objects.get(l).getPositionX()==0) {
						flag2 = true;
					}
				}
				if(!(flag1 || flag2)) 
					objects.get(objectNumber).setPositionX(50);
				else if (flag1 && flag2 == false)
					objects.get(objectNumber).setPositionX(0);
				else {
					objects.get(objectNumber).setPositionX(100);
					objects.get(objectNumber).setPositionY(500);

				}
				objectNumber = 0;
			}
			else 
				objectNumber = 0;
			for (int i = 0; i < 6; i++) {
				objects.get(i).update();
				objects.get(i).render(gc);
			}

		}
		
	}
		else if(objects.get(1).getPositionX() == 150) {
			for(int k = 3 ; k< 6 ; k++) {
				//el mfrod hena azawed condition en ana dost 3ala wa7ed men el f 50 w 0 w 150
				//mesh el 270 da w b3d keda an2el el fo2 tany
				if(objects.get(k).getPositionX() == 270 && k != objectNumber)
					objectNumber = 0;
			}
			if(objectNumber != 0) {
				if(objects.get(1).getPositionX() == 150) {
					objects.get(objectNumber).setPositionX(270);
					objects.get(objectNumber).setPositionY(580);
					objectNumber = 0;
					}
				
			}
		}
		
		return objectNumber;
		
	}


	/*public void makeNewGame() {
		Label scorelabel = new Label();
		scorelabel.setText("Score: " +score);
		//scorelabel.setFont(Font.font ("Verdana", 20));
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setLayoutX(350);
		scorelabel.setLayoutY(100);
		
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
		/*Button move = new Button("Move");
		move.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				score ++;
				scorelabel.setText(Integer.toString(score));
				scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));		
				scorelabel.setTextFill(Color.BROWN);

	            scorelabel.setText("Score: " + score);
				if(objects[1].getPositionX() == 500){
				objects[1].addDeltaX(-350);
				objects[2].addDeltaX(-350);
				for (int j = 3; j < 6; j++) {
					if (objects[j].intersects(objects[1])) {
						objects[j].addDeltaX(-350);
					}
				}
					for (int i = 0; i < 6; i++) {
						objects[i].update();
						objects[i].render(gc);
					}
			}
				else {
					objects[1].addDeltaX(350);
					objects[2].addDeltaX(350);
					for (int j = 3; j < 6; j++) {
						if (objects[j].intersects(objects[1])) {
							objects[j].addDeltaX(350);
						}
					}
						for (int i = 0; i < 6; i++) {
							objects[i].update();
							objects[i].render(gc);
						}
				}

			}
		});*/
	/*	move.setStyle("-fx-font-size: 15pt;");
		move.setLayoutX(380);
		move.setLayoutY(150);
		root.getChildren().add(scorelabel);
		root.getChildren().add(move);
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
				}*/
				
				/*for(int k = 3 ; k<6 ;k++) {
					if(k == objectNumber)
						continue;
					else if(objects[k].intersects(objects[objectNumber])) {
						objectNumber = 0;
				}
				}*/
				// System.out.println("X: " + event.getX() + " Y: " + event.getY());
			/*}
		});*/
		// if(objectNumber != 0) {
		// System.out.println("Hello");
		//new AnimationTimer() {
			@Override
			//public void handle(long arg0) {
				/*for(int k = 3 ; k<6 ;k++) {
					if(k == objectNumber)
						continue;
					else if(objects[k].intersects(objects[objectNumber])) {
						objectNumber = 0;
				}
				}*/
		/*		for(int k =3 ;k<6; k++) {
					if(objects.get(k).getPositionX() == 620)
						objectNumber = 0;
				}
				if (objectNumber != 0 ) {
					if(objects[1].getPositionX() == 500) {
					objects[objectNumber].setPositionX(620);
					objects[objectNumber].setPositionY(580);
					objectNumber = 0;
					}
					else if(objects[objectNumber].intersects(objects[1])){
						boolean flag1 = false;
						boolean flag2 = false;
						for(int l =3 ; l<6 ; l++) {
							if(objects[l].getPositionX() == 50) {
								flag1 = true;
							}
							else if (objects[l].getPositionX()==0) {
								flag2 = true;
							}
						}
						if(!(flag1 || flag2)) 
							objects[objectNumber].setPositionX(50);
						else if (flag1 && flag2 == false)
							objects[objectNumber].setPositionX(0);
						else {
							objects[objectNumber].setPositionX(100);
							objects[objectNumber].setPositionY(500);

						}
						objectNumber = 0;
					}
					else 
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

	}*/

	public void contGame() {
		// TODO Auto-generated method stub

	}

			@Override
			public void makeNewGame() {
				// TODO Auto-generated method stub
				
			}

}
