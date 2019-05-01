package level;

import java.util.List;

import crossers.concreteclasses.Farmer;
import crossers.interfaces.ICrosser;

public class Level2Model extends LevelModel {

	public Level2Model() {
		this.instructions = new String[3];
		fillInitialCrossers();
		fillInstructions();
	}

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
		if (weight > 100)
			boat = false;
		return boat;
	}

	protected void fillInitialCrossers() {

		initialCrossers.add(iCrossersFactory.getICrosser("farmer"));
		initialCrossers.get(0).setWeight(90);
		initialCrossers.get(0)
				.setLabelToBeShown(iCrossersFactory.iCrosserType(initialCrossers.get(0)) + " " + 90 + " Kg");
		initialCrossers.get(0).setNumber(2);

		initialCrossers.add(iCrossersFactory.getICrosser("farmer"));
		initialCrossers.get(1).setWeight(80);
		initialCrossers.get(1)
				.setLabelToBeShown(iCrossersFactory.iCrosserType(initialCrossers.get(1)) + " " + 80 + " Kg");
		initialCrossers.get(1).setNumber(3);

		initialCrossers.add(iCrossersFactory.getICrosser("farmer"));
		initialCrossers.get(2).setWeight(60);
		initialCrossers.get(2)
				.setLabelToBeShown(iCrossersFactory.iCrosserType(initialCrossers.get(2)) + " " + 60 + " Kg");
		initialCrossers.get(2).setNumber(4);

		initialCrossers.add(iCrossersFactory.getICrosser("farmer"));
		initialCrossers.get(3).setWeight(40);
		initialCrossers.get(3)
				.setLabelToBeShown(iCrossersFactory.iCrosserType(initialCrossers.get(3)) + " " + 40 + " Kg");
		initialCrossers.get(3).setNumber(5);

		initialCrossers.add(iCrossersFactory.getICrosser("horse"));
		initialCrossers.get(4).setWeight(20);

		initialCrossers.get(4)
				.setLabelToBeShown(iCrossersFactory.iCrosserType(initialCrossers.get(4)) + " " + 20 + " Kg");
		initialCrossers.get(4).setNumber(6);
	}

	protected void fillInstructions() {
		instructions[0] = "Four farmers and their animals want to cross the river, the weights of the farmers are 90 kg, 80 kg, 60 kg and 40 kg respectively, and the weight of the animal is 20 kg";
		instructions[1] = "The boat cannot bear a load heavier than 100 kg";
		instructions[2] = "All farmers can raft, while the animal cannot";
	}

}
