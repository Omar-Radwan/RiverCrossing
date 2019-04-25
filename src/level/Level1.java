package level;

import java.util.List;

import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;

public class Level1 extends Level {

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
		initialCrossers.add(crossersFactory.getICrosser("farmer"));
		initialCrossers.add(crossersFactory.getICrosser("carrot"));
		initialCrossers.add(crossersFactory.getRandomHerbivorous());
		initialCrossers.add(crossersFactory.getRandomCarnivorous());
	}

	@Override
	protected void fillInstructions() {
		instructions = new String[3];
		instructions[0] = "A farmer wants to cross a river and take with him a carnivorous, a herbivorous and plant";
		instructions[1] = "The farmer is the only one who can sail the boat. He can only take one passenger, in addition to himself";
		instructions[2] = "You can not leave any wo crossers on the same bank if they can harm(eat) each other";
	}

}
