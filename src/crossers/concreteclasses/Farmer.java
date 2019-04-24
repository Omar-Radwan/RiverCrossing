package crossers.concreteclasses;

import crossers.abstractclasses.Human;
import crossers.interfaces.ICrosser;

public class Farmer extends Human {

	public Farmer() {
		super();
		this.images = bufferedImageFactory.getFarmerImages();
	}

	@Override
	public ICrosser makeCopy() {
		// msh3arf kda sa7 wla l2
		ICrosser copy = crossersFactory.getICrosser("farmer");
		copy.setWeight(this.weight);
		return copy;
	}

}
