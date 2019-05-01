package gui.related;

import java.util.ArrayList;
import java.util.Random;

import com.sun.org.apache.bcel.internal.generic.Instruction;

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
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class LevelTemp {
	
	private ArrayList<Sprite> objects =new ArrayList<Sprite>();
	private GraphicsContext gc ; /*canvas.getGraphicsContext2D();*/
	private Canvas canvas = new Canvas(800, 800);
	Group root = new Group();
	private int score=0;
	static Stage stage;
	Sprite temp = new Sprite();
	int objectNumber = 0;
	public LevelTemp() {
		
	}
	public void game(Object g) {
		
		root.getChildren().add(canvas);
		gc = canvas.getGraphicsContext2D();
		DropShadow shadow = new DropShadow();
		Button redo = new Button("Redo");
		redo.setEffect(shadow);
		redo.setStyle(" -fx-background-color: \n" + 
				"        #ecebe9,\n" + 
				"        rgba(0,0,0,0.05),\n" + 
				"        linear-gradient(#dcca8a, #c7a740),\n" + 
				"        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" + 
				"        linear-gradient(#f6ebbe, #e6c34d);\n" + 
				"    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" + 
				"    -fx-background-radius: 50;\n" + 
				"    -fx-padding: 15 30 15 30;\n" + 
				"    -fx-font-family: \"Times New Roman\";\n" + 
				"    -fx-font-size: 10px;\n" + 
				"    -fx-text-fill: #311c09;\n" + 
				"    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

		//redo.setStyle("-fx-font-size: 10pt;");
		redo.setLayoutY(0);
		redo.setLayoutX(720);
		redo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		root.getChildren().add(redo);
		Button exit = new Button ("Exit");
		exit.setStyle(" -fx-background-color: \n" + 
				"        #ecebe9,\n" + 
				"        rgba(0,0,0,0.05),\n" + 
				"        linear-gradient(#dcca8a, #c7a740),\n" + 
				"        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" + 
				"        linear-gradient(#f6ebbe, #e6c34d);\n" + 
				"    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" + 
				"    -fx-background-radius: 50;\n" + 
				"    -fx-padding: 15 30 15 30;\n" + 
				"    -fx-font-family: \"Times New Roman\";\n" + 
				"    -fx-font-size: 12px;\n" + 
				"    -fx-text-fill: #311c09;\n" + 
				"    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

		//exit.setStyle("-fx-font-size: 15pt;");
		exit.setLayoutX(720);
		exit.setLayoutY(750);
		//exit.setEffect(shadow);

		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				//save actions
				System.exit(0);
			}
		});
		root.getChildren().add(exit);
		//DropShadow shadow = new DropShadow();
		Button undo = new Button("Undo");
		undo.setEffect(shadow);
		undo.setLayoutX(0);
		undo.setLayoutY(0);
		undo.setStyle(" -fx-background-color: \n" + 
				"        #ecebe9,\n" + 
				"        rgba(0,0,0,0.05),\n" + 
				"        linear-gradient(#dcca8a, #c7a740),\n" + 
				"        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" + 
				"        linear-gradient(#f6ebbe, #e6c34d);\n" + 
				"    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" + 
				"    -fx-background-radius: 50;\n" + 
				"    -fx-padding: 15 30 15 30;\n" + 
				"    -fx-font-family: \"Times New Roman\";\n" + 
				"    -fx-font-size: 10px;\n" + 
				"    -fx-text-fill: #311c09;\n" + 
				"    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");

		DropShadow shadow3 = new DropShadow();
		
		
		Button instructions = new Button ("Instructions");
		instructions.setEffect(shadow3);
		instructions.setStyle(" -fx-background-color: \n" + 
				"        #ecebe9,\n" + 
				"        rgba(0,0,0,0.05),\n" + 
				"        linear-gradient(#dcca8a, #c7a740),\n" + 
				"        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" + 
				"        linear-gradient(#f6ebbe, #e6c34d);\n" + 
				"    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" + 
				"    -fx-background-radius: 50;\n" + 
				"    -fx-padding: 15 30 15 30;\n" + 
				"    -fx-font-family: \"Times New Roman\";\n" + 
				"    -fx-font-size: 12px;\n" + 
				"    -fx-text-fill: #311c09;\n" + 
				"    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");
		//instructions.setStyle("-fx-font-size: 10pt;");
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
		//DropShadow shadow1 = new DropShadow();
		Button move = new Button("Move");
		move.setEffect(shadow);

		move.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				if(g instanceof Level2) {
					if(Level2.flagMove) {
						score ++;
						Level2.flagMove= false;
								
					}
				}
				if(g instanceof Level1)
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
		//move.setStyle("-fx-font:22 arial;-fx-background-color: lightBlue");
		move.setStyle(" -fx-background-color: \n" + 
				"        #ecebe9,\n" + 
				"        rgba(0,0,0,0.05),\n" + 
				"        linear-gradient(#dcca8a, #c7a740),\n" + 
				"        linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),\n" + 
				"        linear-gradient(#f6ebbe, #e6c34d);\n" + 
				"    -fx-background-insets: 0,9 9 8 9,9,10,11;\n" + 
				"    -fx-background-radius: 50;\n" + 
				"    -fx-padding: 15 30 15 30;\n" + 
				"    -fx-font-family: \"Times New Roman\";\n" + 
				"    -fx-font-size: 18px;\n" + 
				"    -fx-text-fill: #311c09;\n" + 
				"    -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.1) , 2, 0.0 , 0 , 1);");
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
				System.out.println(temp.getPositionY());
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
