package crossers.concreteclasses;

import crossers.abstractclasses.Carnivorous;
import crossers.interfaces.Crosser;
import crossers.interfaces.ICrosser;

public class Wolf extends Carnivorous {

	public Wolf() {
		super();
		this.images = bufferedImageFactory.getWolfImages();
	}
	
	@Override
	public ICrosser makeCopy() {
		Crosser copy = crossersFactory.getCrosser("wolf");
		copy.setWeight(this.weight);
		return copy;
	}

}
