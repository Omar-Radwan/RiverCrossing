package level;

import java.util.List;

import crossers.ICrossersFactory;
import crossers.interfaces.ICrosser;

public abstract class Level implements ICrossingStrategy {

	protected List<ICrosser> initialCrossers;
	protected String[] instructions;
	protected ICrossersFactory crossersFactory;

	protected Level() {
		crossersFactory = ICrossersFactory.getInstance();
		fillInitialCrossers();
		fillInstructions();
	}

	@Override
	public List<ICrosser> getInitialCrossers() {
		return initialCrossers;
	}

	@Override
	public String[] getInstructions() {
		return instructions;
	}

	protected abstract void fillInitialCrossers();

	protected abstract void fillInstructions();
}
