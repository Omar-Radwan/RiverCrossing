package crossers.concreteclasses;

import crossers.abstractclasses.Human;
import crossers.interfaces.Crosser;
import crossers.interfaces.ICrosser;

public class  Farmer extends Human {
	
	public Farmer() {
		super ();
		this.images = bufferedImageFactory.getFarmerImages();
	}

	@Override
	public ICrosser makeCopy() {
		Crosser copy = crossersFactory.getCrosser("farmer");
		copy.setWeight(this.weight);
		return copy;
	}



}
