package level;

import java.util.LinkedList;
import java.util.List;

import crossers.ICrossersFactory;
import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;

public class Level1 extends Level {

	public Level1() {
		super();
		this.instructions = new String[3];
		this.initialCrossers = new LinkedList<ICrosser>();
	}

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		boolean boat = false;
		boolean rightBank = true;
		boolean leftBank = true;
		for (ICrosser x : boatRiders) {
			if (x instanceof Farmer)
				boat = true;
		}
		if (boatRiders.size() > 2)
			boat = false;
		if (leftBankCrossers.size() == 2)
			if (Math.abs(leftBankCrossers.get(0).getEatingRank() - leftBankCrossers.get(1).getEatingRank()) == 1)
				leftBank = false;
		if (rightBankCrossers.size() == 2)
			if (Math.abs(rightBankCrossers.get(0).getEatingRank() - rightBankCrossers.get(1).getEatingRank()) == 1)
				rightBank = false;
		return boat && rightBank && leftBank;
	}

	@Override
	protected void fillInitialCrossers() {
		this.initialCrossers.add(crossersFactory.getICrosser("farmer"));
		this.initialCrossers.add(crossersFactory.getICrosser("carrot"));
		this.initialCrossers.add(crossersFactory.getRandomHerbivorous());
		this.initialCrossers.add(crossersFactory.getRandomCarnivorous());
	}

	@Override
	protected void fillInstructions() {
		this.instructions[0] = "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant";
		this.instructions[1] = "The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself";
		this.instructions[2] = "You can not leave any wo crossers on the same bank if they can harm(eat) each other";
	}


}
