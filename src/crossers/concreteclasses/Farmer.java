package crossers.concreteclasses;

import java.util.Arrays;

import crossers.abstractclasses.Human;
import crossers.interfaces.ICrosser;

public class Farmer extends Human {

	public Farmer() {
		super();
		this.images = bufferedImageFactory.getFarmerImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = iCrossersFactory.getICrosser("farmer");
		copy.setWeight(this.weight);
		return copy;
	}

}
