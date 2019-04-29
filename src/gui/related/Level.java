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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class Level {
	
	private ArrayList<Sprite> objects =new ArrayList<Sprite>();
	private GraphicsContext gc ; /*canvas.getGraphicsContext2D();*/
	private Canvas canvas = new Canvas(800, 800);
	Group root = new Group();
	private int score=0;
	static Stage stage;
	Sprite temp = new Sprite();
	int objectNumber = 0;
	public Level() {
		
	}
	public void game(Object g) {
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		Button redo = new Button("Redo");
		redo.setStyle("-fx-font-size: 15pt;");
		redo.setLayoutY(0);
		redo.setLayoutX(730);
		redo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		root.getChildren().add(redo);
		Button exit = new Button ("Exit");
		exit.setStyle("-fx-font-size: 15pt;");
		exit.setLayoutX(740);
		exit.setLayoutY(755);
		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//save actions
				System.exit(0);
			}
		});
		root.getChildren().add(exit);
		Button undo = new Button("Undo");
		undo.setStyle("-fx-font-size: 15pt;");
		undo.setLayoutX(0);
		undo.setLayoutY(0);
		Button instructions = new Button ("Instructions");
		instructions.setStyle("-fx-font-size: 15pt;");
		instructions.setLayoutX(680);
		instructions.setLayoutY(50);
		root.getChildren().add(instructions);
		instructions.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if(g instanceof Level1) {
					//array labels lel instructions
				}
				else if (g instanceof Level2) {
					//array labels le instructions level 2
				}
				
			}
		});
		HBox hb = new HBox();
		hb.getChildren().add(undo);
		hb.setSpacing(10);
		if(g instanceof Level1) {
		objects=Level1.objects;
		}
		else if (g instanceof Level2) {
			objects = Level2.objects;
			hb.getChildren().add(Level2.menu);
		}
		for(int i = 0 ; i< objects.size() ; i++) {
			objects.get(i).render(gc);
		}
		root.getChildren().add(hb);
		redo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		undo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// gemy's shit
				
			}
		});
		Label scorelabel = new Label();
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setLayoutX(360);
		scorelabel.setLayoutY(100);
		Button move = new Button("Move");
		move.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				score ++;
				scorelabel.setText(Integer.toString(score));
				scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));		
				scorelabel.setTextFill(Color.BROWN);
	            scorelabel.setText("Score: " + score);
	            if(g instanceof Level1) {
					((Level1) g).moveOnAction(gc);
					objects = Level1.objects;
	            }
	           if(g instanceof Level2) {
					((Level2) g).moveOnAction(gc);
					objects=Level2.objects;
	            }
	            
			}
		});/*for(int k = 3 ; k< 6 ; k++) {
				//el mfrod hena azawed condition en ana dost 3ala wa7ed men el f 50 w 0 w 150
				//mesh el 270 da w b3d keda an2el el fo2 tany
				if(objects.get(k).intersects(temp) && objects.get(k).getPositionX() != 270) {
				for(int i =3 ; i<6 ;i++) {
					if(objects.get(i).getPositionX() == 270 )
					objectNumber = 0;
			}}}
			if(objectNumber != 0) {
				//System.out.println("FU");
				if(objects.get(1).getPositionX() == 150) {
					objects.get(objectNumber).setPositionX(270);
					objects.get(objectNumber).setPositionY(580);
					objectNumber = 0;
					}
				
			}*/
		move.setStyle("-fx-font-size: 15pt;");
		move.setLayoutX(360);
		move.setLayoutY(150);
		root.getChildren().add(scorelabel);
		root.getChildren().add(move);
		Scene level = new Scene(root, 800, 800);
		level.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				temp.setPositionX(event.getX());
				temp.setPositionY(event.getY());
				if(g instanceof Level1) {
					for (int i = 3; i < 6; i++) {
						if (objects.get(i).intersects(temp)) {
							objectNumber = i;
							Level1.objectNumber = objectNumber;
							Level1.x = objectNumber;
						}
					}
				}
				else if(g instanceof Level2) {
					for (int i = 2; i < 7; i++) {
						if (objects.get(i).intersects(temp)) {
							objectNumber = i;
							Level2.objectNumber = objectNumber;
						}
					}
				}
				
				
			}
		});
		
		new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				if(g instanceof Level1) {
				objectNumber =((Level1) g).animationSet(gc); 
				objects = Level1.objects;
				}
			else if(g instanceof Level2) { 
				objectNumber =((Level2) g).animationSet(gc); 
				objects = Level2.objects;
			}
			}
			
		}.start();
		stage.setScene(level);
	}
	
	
	
	
}
