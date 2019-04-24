import java.util.List;

import crossers.interfaces.ICrosser;

public class CrossingStrategy implements ICrossingStrategy {
	private List<ICrosser> leftBankCrossers;
	private List<ICrosser> rightBankCrossers;
	private List<ICrosser> boatRiders;
	private String[] instructions=new String[5];
	// lessa mesh mota2aked el setters wel getters btoo3 el crossers leehom lazma henna walla la2
	
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
