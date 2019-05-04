package gui.related;

import javax.swing.JFrame;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InvalidMove {
	private JFrame frame = new JFrame();

	public void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("");
		window.setMinWidth(250);
		Label label = new Label("Invalid move !");
		Button close = new Button("Close");
		close.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
				window.close();
				
			}
		});
		VBox vb = new VBox(10);
		vb.getChildren().addAll(label, close);
		vb.setAlignment(Pos.CENTER);
		Scene scene = new Scene(vb);
		window.setScene(scene);
		window.show();

	}

}
