package controller;

import java.util.HashMap;
import java.util.List;

import controller.commands.LoadCommand;
import controller.commands.NewGameCommand;
import controller.commands.RedoCommand;
import controller.commands.ResetGameCommand;
import controller.commands.SaveCommand;
import controller.commands.UndoCommand;
import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;
import crossers.interfaces.ICrosser;
import gui.related.Level;
import gui.related.Level1;
import gui.related.Level2;
import level.ICrossingStrategy;
import level.Level1Model;

public class RiverCrossingController implements IRiverCrossingController {
	private HashMap<String, Command> commandMap;

	private GameState gameState;
	public Level levelView;
	private CareTaker careTaker = CareTaker.getInstance();

	// singleton
	private static RiverCrossingController instance;

	private RiverCrossingController() {
		commandMap = new HashMap<String, Command>();
		gameState = new GameState();
		commandMap.put("save", new SaveCommand(gameState));
		commandMap.put("load", new LoadCommand(gameState));
		commandMap.put("reset", new ResetGameCommand(gameState));
		commandMap.put("undo", new UndoCommand(careTaker, gameState));
		commandMap.put("redo", new RedoCommand(careTaker, gameState));
	};

	public static RiverCrossingController getInstance() {
		if (instance == null)
			instance = new RiverCrossingController();
		return instance;
	}

	@Override
	public void undo() {
		commandMap.get("undo").execute();
		updateView();
		levelView.renderObjects();
		levelView.updateScoreLabel();

	}

	@Override
	public void redo() {
		commandMap.get("redo").execute();
		updateView();
		levelView.renderObjects();
		levelView.updateScoreLabel();
	}

	@Override
	public boolean canUndo() {
		if (careTaker.isUndoStackEmpty())
			return false;
		else
			return true;
	}

	@Override
	public boolean canRedo() {
		if (careTaker.isRedoStackEmpty())
			return false;
		else
			return true;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		commandMap.put("newgame", new NewGameCommand(gameState, gameStrategy));
		commandMap.get("newgame").execute();

		updateView();
		levelView.draw();
		levelView.updateScoreLabel();
	}

	@Override
	public void resetGame() {
		commandMap.get("reset").execute();
		updateView();
		levelView.renderObjects();
		levelView.updateScoreLabel();
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		this.gameState.setCrossersOnLeftBank(crossersOnLeftBank);
	}

	public List<ICrosser> getBoatRiders() {
		return gameState.getBoatRiders();
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		gameState.setBoatRiders(boatRiders);
	}

	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.gameState.setCrossersOnRightBank(crossersOnRightBank);
	}

	public void setNumberOfSails(int numberOfSails) {
		this.gameState.setNumberOfSails(numberOfSails);
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		Memento m = new Memento(gameState.getCrossersOnRightBank(), gameState.getCrossersOnLeftBank(),
				gameState.getBoatRiders(), gameState.isBoatOnTheLeftBank(), gameState.getNumberOfSails());
		careTaker.addMemento(m);

		return gameState.canMove(crossers, fromLeftToRightBank);

	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		careTaker.resetRedoStack();
		gameState.doMove(crossers, fromLeftToRightBank);
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	// should handle these exceptions in the view

	@Override
	public void saveGame() {
		commandMap.get("save").execute();
	}

	@Override
	public void loadGame() {
		commandMap.get("load").execute();
		updateView();
		levelView.draw();
		levelView.updateScoreLabel();
	}

	/*
	 * interface getters .... al 7ta di 5lst mtgesh gnbaha tany
	 */

	// -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	@Override
	public List<ICrosser> getCrosserOnLeftBank() {
		return gameState.getCrossersOnLeftBank();
	}

	@Override
	public String[] getInstructions() {
		return gameState.getGameStrategy().getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return gameState.getCrossersOnRightBank();
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return gameState.isBoatOnTheLeftBank();
	}

	@Override
	public int getNumberOfSails() {
		return gameState.getNumberOfSails();
	}

	@Override
	public void setStrategy(ICrossingStrategy gameStrategy) {
		this.gameState.setGameStrategy(gameStrategy);
		if (gameStrategy instanceof Level1Model) {
			levelView = new Level1();
		} else {
			levelView = new Level2();
		}

	}

	@Override
	public void setView(Level levelView) {
		this.levelView = levelView;
	}

	public void updateView() {
		levelView.setCrossersPositionsAndImages();
		levelView.setBoatPosition();

	}
}
