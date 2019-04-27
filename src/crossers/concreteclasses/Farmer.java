package crossers.concreteclasses;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlRootElement;

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
		ICrosser copy = iCrossersFactory.getICrosser("farmer");
		copy.setWeight(this.weight);
		return copy;
	}

	@Override
	public String toString() {
		return "Farmer [canSail=" + canSail + ", weight=" + weight + ", eatingRank=" + eatingRank + ", images="
				+ Arrays.toString(images) + ", bufferedImageFactory=" + bufferedImageFactory + ", labelToBeShown="
				+ labelToBeShown + "]";
	}

}
