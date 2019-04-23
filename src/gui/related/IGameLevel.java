package gui.related;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public abstract class IGameLevel {
	public void selectlevel(Stage stage , Object gameLevel) {
		Button newGame = new Button("New game");
		Button loadGame = new Button("Continue");
		newGame.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(gameLevel instanceof Level1) {
					
				}
				else if(gameLevel instanceof Level2) {
					
				}
				
			}
		});
		loadGame.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		VBox vb = new VBox(10);
		vb.getChildren().addAll(newGame , loadGame);
		Scene scene = new Scene(vb , 800 , 800);
		stage.setScene(scene);
		
	}
	// ha3mel beha new game
	public abstract void makeNewGame() ;
	//ha3mel beha continue lel game fa lazem a2ra mel file
	public abstract void contGame();
	

}
