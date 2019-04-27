package crossers.concreteclasses;

import crossers.abstractclasses.Carnivorous;
import crossers.interfaces.ICrosser;

public class Wolf extends Carnivorous {

	public Wolf() {
		super();
		this.images = bufferedImageFactory.getWolfImages();
	}

	@Override
	public ICrosser makeCopy() {
		ICrosser copy = iCrossersFactory.getICrosser("wolf");
		copy.setWeight(this.weight);
		return copy;
	}

}
