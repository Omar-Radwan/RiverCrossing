
import java.io.FileNotFoundException;
import java.util.List;

import javax.xml.transform.TransformerException;

import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;

public interface IRiverCrossingController {

	public void newGame(ICrossingStrategy gameStrategy);

	public void resetGame();

	public String[] getInstructions();

	public List<ICrosser> getCrossersOnRightBank();

	public List<ICrosser> getCrosserOnLeftBank();

	public boolean isBoatOnTheLeftBank();

	public int getNumberOfSails();

	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank);

	public boolean canUndo();

	public boolean canRedo(CareTaker T);

	public void undo(Memento M);

	public void redo(Memento M);

	public void saveGame() throws FileNotFoundException, TransformerException;

	public void loadGame();

	public List<List<ICrosser>> solveGame();

	List<ICrosser> getCrossersOnLeftBank();

}
