package controller.interfaces;

import java.util.List;

import crossers.interfaces.ICrosser;
import gui.related.Level;
import level.ICrossingStrategy;

public interface IRiverCrossingController {

	/*
	 * Commands
	 */
	public void newGame(ICrossingStrategy gameStrategy);

	public void resetGame();

	/*
	 * Getters
	 */
	public String[] getInstructions();

	public List<ICrosser> getCrossersOnRightBank();

	public List<ICrosser> getCrosserOnLeftBank();

	public boolean isBoatOnTheLeftBank();

	public int getNumberOfSails();

	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	/*
	 * Command
	 */
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	public boolean canUndo();

	public boolean canRedo();

	/*
	 * Commands
	 */
	public void undo();

	public void redo();

	public void saveGame();

	public void loadGame();

	public List<List<ICrosser>> solveGame();


	public void setStrategy(ICrossingStrategy gameStrategy);

	public void setView(Level levelView);

}
