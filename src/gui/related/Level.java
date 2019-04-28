package gui.related;

import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
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
		Button undo = new Button("Undo");
		undo.setStyle("-fx-font-size: 15pt;");
		undo.setLayoutX(0);
		undo.setLayoutY(0);
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
		
		undo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				// gemy's shit
				
			}
		});
		Label scorelabel = new Label();
		scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
		scorelabel.setTextFill(Color.BROWN);
		scorelabel.setLayoutX(380);
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
		});
		move.setStyle("-fx-font-size: 15pt;");
		move.setLayoutX(380);
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
