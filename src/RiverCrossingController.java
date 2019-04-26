import java.util.List;

import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;

public class RiverCrossingController implements IRiverCrossingController {
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private List<ICrosser> boatRiders;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;
	private String[] instructions = new String[5];
	private static RiverCrossingController instance;

	private RiverCrossingController() {
	};

	public static RiverCrossingController getInstance() {
		if (instance == null)
			instance = new RiverCrossingController();
		return instance;
	}

	public Memento save() {
		return new Memento(crossersOnRightBank, crossersOnLeftBank, boatRiders, isBoatOnTheLeftBank, numberOfSails);
	}

	public void restore(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public String[] getInstructions() {
		return instructions;
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		this.crossersOnLeftBank = crossersOnLeftBank;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		this.boatRiders = boatRiders;
	}

	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.crossersOnRightBank = crossersOnRightBank;
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}

	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUndo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRedo() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void loadGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ICrosser> getCrosserOnLeftBank() {
		return crossersOnLeftBank;
	}

}
