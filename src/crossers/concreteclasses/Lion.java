package crossers.concreteclasses;

import crossers.abstractclasses.Carnivorous;
import crossers.interfaces.Crosser;
import crossers.interfaces.ICrosser;

public class Lion extends Carnivorous {

	public Lion() {
		super();
		this.images = bufferedImageFactory.getLionImages();
	}
	@Override
	public ICrosser makeCopy() {
		Crosser copy = crossersFactory.getCrosser("lion");
		copy.setWeight(this.weight);
		return copy;
	}

}
