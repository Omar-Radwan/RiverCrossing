import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;

import crossers.BufferedImagesGetter;
import crossers.ICrossersFactory;
import crossers.abstractclasses.CrosserAC;
import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;
import gui.related.HomeScreen;
//import gui.related.HomeScreen;
import javafx.application.Application;
import javafx.stage.Stage;
import level.ICrossingStrategy;
import level.Level1Model;
import level.Level2Model;

import org.w3c.dom.*;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class Main extends Application {

	public static void main(String[] args) throws IOException, ParserConfigurationException {

		ICrossersFactory iCrossersFactory = ICrossersFactory.getInstance();
		BufferedImagesGetter bufferedImagesGetter = BufferedImagesGetter.getInstance();

		CrosserAC.setICrosserFactory(iCrossersFactory);
		CrosserAC.setBufferedImageFactory(bufferedImagesGetter);

		RiverCrossingController riverCrossingController = RiverCrossingController.getInstance();
		ICrossingStrategy iCrossingStrategy = new Level2Model();
		riverCrossingController.newGame(iCrossingStrategy);

		riverCrossingController.saveGame();
		riverCrossingController.loadGame();
		// launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		HomeScreen homeScreen = new HomeScreen(primaryStage);
		primaryStage.setTitle("River crossing");
		homeScreen.Homescreen();
		// primaryStage.setScene(homeScreen.getScene());
		primaryStage.show();

	}

}
