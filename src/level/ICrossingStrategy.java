package level;

import java.util.List;

import crossers.interfaces.ICrosser;

public interface ICrossingStrategy {

	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders);

	public List<ICrosser> getInitialCrossers();

	public String[] getInstructions();

}
