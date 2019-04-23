package crossers.concreteclasses;

import crossers.abstractclasses.Plant;
import crossers.interfaces.Crosser;
import crossers.interfaces.ICrosser;

public class Carrot extends Plant {

	public Carrot() {
		super();
		this.bufferedImageFactory.getCarrotImages();
	}

	@Override
	public ICrosser makeCopy() {
		Crosser copy = crossersFactory.getCrosser("carrot");
		copy.setWeight(this.weight);
		return copy;
	}

}
