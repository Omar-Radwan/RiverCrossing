import java.util.List;

import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;

public class CrossingStrategy implements ICrossingStrategy {
	private List<ICrosser> leftBankCrossers;
	private List<ICrosser> rightBankCrossers;
	private List<ICrosser> boatRiders;
	private String[] instructions=new String[5];
	
	@Override
	public List<ICrosser> getInitialCrossers() {
		return leftBankCrossers;
	}

	public void setLeftBankCrossers(List<ICrosser> leftBankCrossers) {
		this.leftBankCrossers = leftBankCrossers;
	}

	public List<ICrosser> getRightBankCrossers() {
		return rightBankCrossers;
	}

	public void setRightBankCrosser(List<ICrosser> rightBankCrossers) {
		this.rightBankCrossers = rightBankCrossers;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		this.boatRiders = boatRiders;
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		// TODO Auto-generated method stub
		return false;
	}

	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
	}

	@Override
	public String[] getInstructions() {

		return instructions;
	}

}
