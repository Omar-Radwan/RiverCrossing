package level;

import java.util.List;

import crossers.ICrossersFactory;
import crossers.interfaces.ICrosser;

public abstract class Level implements ICrossingStrategy {

	protected List<ICrosser> initialCrossers;
	protected String[] instructions;
	protected ICrossersFactory crossersFactory;

	public Level() {}

	public ICrossersFactory getCrossersFactory() {
		return crossersFactory;
	}

	public void setCrossersFactory(ICrossersFactory crossersFactory) {
		this.crossersFactory = crossersFactory;
	}

	public void setInitialCrossers(List<ICrosser> initialCrossers) {
		this.initialCrossers = initialCrossers;
	}

	public void setInstructions(String[] instructions) {
		this.instructions = instructions;
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

	@Override
	public void prepare() {
		this.crossersFactory = ICrossersFactory.getInstance();
		fillInitialCrossers();
		fillInstructions();
		
	}


}
