package level;

import java.util.LinkedList;
import java.util.List;

import crossers.ICrossersFactory;
import crossers.interfaces.ICrosser;

public abstract class LevelModel implements ICrossingStrategy {

	protected List<ICrosser> initialCrossers;
	protected String[] instructions;
	protected ICrossersFactory iCrossersFactory;
	
	public LevelModel() {
		iCrossersFactory = ICrossersFactory.getInstance();
		this.initialCrossers = new LinkedList<ICrosser>();
	}

	public ICrossersFactory getCrossersFactory() {
		return iCrossersFactory;
	}

	public void setCrossersFactory(ICrossersFactory crossersFactory) {
		this.iCrossersFactory = crossersFactory;
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



}
