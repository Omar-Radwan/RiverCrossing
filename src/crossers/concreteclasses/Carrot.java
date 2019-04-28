package crossers.concreteclasses;

import crossers.abstractclasses.Plant;
import crossers.interfaces.ICrosser;

public class Carrot extends Plant {

	public Carrot() {
		super();
		this.images = bufferedImageFactory.getCarrotImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = iCrossersFactory.getICrosser("carrot");
		copy.setWeight(this.weight);
		return copy;
	}

}
