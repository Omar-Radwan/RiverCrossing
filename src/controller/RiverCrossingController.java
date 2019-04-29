package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import controller.commands.LoadCommand;
import controller.commands.SaveCommand;
import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;
import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;

public class RiverCrossingController implements IRiverCrossingController {

	private GameState gameState;
	private HashMap<String, Command> commandMap;

	private Stack<Memento> undoStack;
	private Stack<Memento> redoStack;

	// singleton
	private static RiverCrossingController instance;

	private RiverCrossingController() {
		commandMap = new HashMap<String, Command>();

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
				return false;
			}

		}

		else {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnRightBank().add(x);
			}

			if (!gameState.getGameStrategy().isValid(gameState.getCrossersOnRightBank(),
					gameState.getCrossersOnLeftBank(), crossers)) {
				doMove(crossers, fromLeftToRightBank);
				return true;
			} else {
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
		} else {
			for (ICrosser x : crossers) {
				gameState.getCrossersOnLeftBank().add(x);
			}
		}
	}

	@Override
	public boolean canUndo() {
		return !undoStack.isEmpty();
	}

	@Override
	public boolean canRedo() {
		return !redoStack.isEmpty();
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	// should handle these exceptions in the view

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {

	}

	@Override
	public void saveGame() {
		commandMap.get("save").execute();

	}

	@Override
	public void loadGame() {
		commandMap.get("load").execute();
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
	public List<ICrosser> getCrossersOnLeftBank() {
		return gameState.getCrossersOnLeftBank();
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return gameState.isBoatOnTheLeftBank();
	}

	@Override
	public int getNumberOfSails() {
		return gameState.getNumberOfSails();
	}

	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------

}
