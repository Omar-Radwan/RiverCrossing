import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;

@XmlRootElement
public class RiverCrossingController implements IRiverCrossingController {
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private List<ICrosser> boatRiders;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;
	private int index = 0;
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
		setIndex(getIndex() + 1);
		return new Memento(crossersOnRightBank, crossersOnLeftBank, boatRiders, isBoatOnTheLeftBank, numberOfSails);
	}

	@Override
	public void undo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
		setIndex(getIndex() - 1);
	}

	@Override
	public void redo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
		setIndex(getIndex() + 1);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
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
		if (index == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean canRedo(CareTaker T) {
		if (index == T.getSize() - 1)
			return false;
		else
			return true;
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
