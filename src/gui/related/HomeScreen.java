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
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class HomeScreen {
//private Image image;
	private Stage stage;
	private Scene scenehomescreen;
	private IGameLevel gameLevel;

	public HomeScreen(Stage stage1) {
		this.stage = stage1;
	}

	public void Homescreen() {
		VBox label = new VBox();
		Label l1 = new Label("River Crossing puzzle");
		label.getChildren().add(l1);
		label.setAlignment(Pos.CENTER);
		HBox buttons = new HBox(10);
		Button level1 = new Button("Level 1");
		level1.setStyle("-fx-font-size: 15pt;");

		level1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				gameLevel = new Level1(stage);
				gameLevel.selectlevel(stage, gameLevel);
			}
		});

		Button level2 = new Button("Level 2");
		level2.setStyle("-fx-font-size: 15pt;");

		buttons.setAlignment(Pos.CENTER);
		level2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {

				gameLevel = new Level2();
				gameLevel.selectlevel(stage, gameLevel);
			}
		});
		buttons.getChildren().addAll(level1, level2);
		GridPane grid = new GridPane();
		Button exit = new Button("Exit");
		grid.setAlignment(Pos.CENTER);
		grid.add(exit, 10, 10);
		exit.setStyle("-fx-font-size: 15pt;");

		exit.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		VBox vb = new VBox(10);
		vb.getChildren().addAll(label, buttons, grid);
		scenehomescreen = new Scene(vb, 800, 800);
		stage.setScene(scenehomescreen);

	}

}
