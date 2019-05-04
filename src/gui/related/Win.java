package gui.related;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Win {

	public void display() {
		Stage window = new Stage();

		// lazem yt3amel ma3 el window de el awal
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("");
		window.setMinWidth(250);
		Label label = new Label("You Won !");
		Button close = new Button("Exit");
		close.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.exit(0);
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
