package gui.related;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.control.TextArea;
import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class HomeScreen {
	 //private Image image;
		private Stage stage;
		private Scene scenehomescreen;
	 
	 public HomeScreen(Stage stage1) {
		 //Image image = new Image ("file:backgroundColorForest.png");
		 this.stage=stage1;
		 
		 
		 
	 }
	 public void HomeScreen() {
		 VBox label= new VBox();
		 Label l1= new Label("River Crossing puzzle");
		 label.getChildren().add(l1);
		 label.setAlignment(Pos.CENTER);
		 HBox buttons = new HBox();
		 Button level1 = new Button ("Level 1");
		 level1.setMaxSize(100, 200);
		 level1.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
				}
			});
		 
		Button level2 = new Button ("Level 2");
		level2.setMaxSize(100, 200);
		level2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
				}
			});
		 buttons.getChildren().addAll(level1,level2);
		 GridPane grid = new GridPane();
		 Button exit = new Button ("Exit");
		 grid.add(exit, 10, 10);
		 GridPane.setHalignment(exit, HPos.LEFT);
		 exit.setMaxSize(100, 200);
		 exit.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent e) {
					
				}
			});
		 
		 
		 stage.setScene(scenehomescreen);
		 
	 }
	 
	 public Scene getScene () {
		 return scenehomescreen;
	 }
	 
	
	 
	 
	 
	 
	 
	 
	 
	
	
	

}
