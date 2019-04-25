package level;

import java.util.List;

import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;

public class Level2 extends Level {

	@Override
	public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers,
			List<ICrosser> boatRiders) {
		boolean boat = false;
		double weight = 0;
		for (ICrosser x : boatRiders) {
			if (x instanceof Farmer)
				boat = true;
			weight += x.getWeight();
		}
		if(weight>100)
			boat=false;
		return boat;
	}

	@Override
	protected void fillInitialCrossers() {

		initialCrossers.add(crossersFactory.getICrosser("farmer"));
		initialCrossers.add(crossersFactory.getICrosser("farmer"));
		initialCrossers.add(crossersFactory.getICrosser("farmer"));
		initialCrossers.add(crossersFactory.getICrosser("farmer"));

		initialCrossers.add(crossersFactory.getRandomHerbivorous());
		initialCrossers.add(crossersFactory.getRandomHerbivorous());
		initialCrossers.add(crossersFactory.getRandomHerbivorous());
		initialCrossers.add(crossersFactory.getRandomHerbivorous());

	}

	@Override
	protected void fillInstructions() {
		instructions = new String[3];
		instructions[0] = "Four farmers and their animals want to cross the river, the weights of the farmers are 90 kg, 80 kg, 60 kg and 40 kg respectively, and the weight of the animal is 20 kg";
		instructions[1] = "The boat cannot bear a load heavier than 100 kg";
		instructions[2] = "All farmers can raft, while the animal cannot";
	}

}
