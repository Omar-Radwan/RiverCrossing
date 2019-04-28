package crossers.concreteclasses;

import crossers.abstractclasses.Herbivorous;
import crossers.interfaces.ICrosser;

public class Sheep extends Herbivorous {

	public Sheep() {
		super();
		this.images = bufferedImageFactory.getSheepImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = iCrossersFactory.getICrosser("sheep");
		copy.setWeight(this.weight);
		return copy;
	}

}
