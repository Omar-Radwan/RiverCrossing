package controller;

import java.util.HashMap;
import java.util.List;

import controller.commands.LoadCommand;
import controller.commands.SaveCommand;
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

	// singleton
	private static RiverCrossingController instance;
	CareTaker careTaker = CareTaker.getInstance();

	private RiverCrossingController() {
		commandMap = new HashMap<String, Command>();
		gameState = new GameState();
		commandMap.put("save", new SaveCommand());
		commandMap.put("load", new LoadCommand());
	};

	public static RiverCrossingController getInstance() {
		if (instance == null)
			instance = new RiverCrossingController();
		return instance;
	}

	/*
	 * public Memento save() { setIndex(getIndex() + 1); return new
	 * Memento(crossersOnRightBank, crossersOnLeftBank, boatRiders,
	 * isBoatOnTheLeftBank, numberOfSails); }
	 * 
	 * @Override public void undo(Memento m) { boatRiders = m.getBoatRiders();
	 * crossersOnRightBank = m.getCrossersOnRightBank(); crossersOnLeftBank =
	 * m.getCrossersOnLeftBank(); numberOfSails = m.getNumberOfSails();
	 * isBoatOnTheLeftBank = m.isBoatOnTheLeftBank(); setIndex(getIndex() - 1); }
	 * 
	 * @Override public void redo(Memento m) { boatRiders = m.getBoatRiders();
	 * crossersOnRightBank = m.getCrossersOnRightBank(); crossersOnLeftBank =
	 * m.getCrossersOnLeftBank(); numberOfSails = m.getNumberOfSails();
	 * isBoatOnTheLeftBank = m.isBoatOnTheLeftBank(); setIndex(getIndex() + 1); }
	 * 
	 * public int getIndex() { return index; }
	 * 
	 * public void setIndex(int index) { this.index = index; }
	 */

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameState.setGameStrategy(gameStrategy);

		resetGame();

		if (gameStrategy instanceof Level1Model) {
			levelView = new Level1();
		} else {
			levelView = new Level2();
		}

		levelView.draw();
	}

	@Override
	public void resetGame() {
		gameState.reset();
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

		if (fromLeftToRightBank == true) {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnLeftBank().remove(x);
			}

			if (gameState.getGameStrategy().isValid(gameState.getCrossersOnRightBank(),
					gameState.getCrossersOnLeftBank(), crossers)) {
				doMove(crossers, fromLeftToRightBank);
				return true;
			} else {
				for (ICrosser x : crossers) {
					gameState.getCrossersOnLeftBank().add(x);
				}
				return false;
			}

		}

		else {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnRightBank().remove(x);
			}

			if (gameState.getGameStrategy().isValid(gameState.getCrossersOnRightBank(),
					gameState.getCrossersOnLeftBank(), crossers)) {
				Memento m = new Memento(gameState);
				careTaker.addMemento(m);
				doMove(crossers, fromLeftToRightBank);
				return true;
			} else {
				for (ICrosser x : crossers) {
					gameState.getCrossersOnRightBank().add(x);
				}
				return false;
			}
		}

	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

		if (fromLeftToRightBank) {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnRightBank().add(x);
			}
			gameState.setBoatOnTheLeftBank(false);
		} else {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnLeftBank().add(x);
			}
			gameState.setBoatOnTheLeftBank(true);
		}
	}

	@Override
	public boolean canUndo() {
		return true;
	}

	@Override
	public boolean canRedo() {
		return false;
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	// should handle these exceptions in the view

	@Override
	public void undo() {
		this.gameState = careTaker.undo();
	}

	@Override
	public void redo() {

	}

	@Override
	public void saveGame() {
		// commandMap.get("save").execute();
		gameState.saveStateToXml();
	}

	@Override
	public void loadGame() {
		gameState.loadFromXml();
		levelView.draw();
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

	}

	@Override
	public void setView(Level levelView) {
		this.levelView = levelView;
	}

}
