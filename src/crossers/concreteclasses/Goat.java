package crossers.concreteclasses;

import crossers.abstractclasses.Herbivorous;
import crossers.interfaces.Crosser;
import crossers.interfaces.ICrosser;

public class Goat extends Herbivorous {

	public Goat() {
		super();
		this.images = bufferedImageFactory.getGoatImages();
	}
	
	@Override
	public ICrosser makeCopy() {
		Crosser copy = crossersFactory.getCrosser("goat");
		copy.setWeight(this.weight);
		return copy;
	}

}
