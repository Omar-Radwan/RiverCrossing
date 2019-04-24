package crossers.concreteclasses;

import crossers.abstractclasses.Plant;
import crossers.interfaces.ICrosser;

public class Carrot extends Plant {

	public Carrot() {
		super();
		this.bufferedImageFactory.getCarrotImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = crossersFactory.getICrosser("carrot");
		copy.setWeight(this.weight);
		return copy;
	}

}
