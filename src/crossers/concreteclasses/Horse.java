package crossers.concreteclasses;

import crossers.abstractclasses.Herbivorous;
import crossers.interfaces.ICrosser;

public class Horse extends Herbivorous {
	public Horse() {
		super();
		this.images = bufferedImageFactory.getHorseImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = iCrossersFactory.getICrosser("horse");
		copy.setWeight(this.weight);
		return copy;
	}

}
