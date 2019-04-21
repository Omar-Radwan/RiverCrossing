package crossers;

import crossers.concreteclasses.Carrot;
import crossers.concreteclasses.Farmer;
import crossers.concreteclasses.Goat;
import crossers.concreteclasses.Lion;
import crossers.concreteclasses.Sheep;
import crossers.concreteclasses.Wolf;

public class CrossersFactory {

	public CrossersFactory() {}
	
	public ICrosser getCrosser (String type) {
		
		if (type.equalsIgnoreCase("farmer")) {
			return new Farmer();
		}
		else if (type.equalsIgnoreCase("lion")) {
			return new Lion();
		}
		else if (type.equalsIgnoreCase("wolf")) {
			return new Wolf();
		}
		else if (type.equalsIgnoreCase("goat")) {
			return new Goat();
		}
		else if(type.equalsIgnoreCase("sheep")) {
			return new Sheep();
		}
		else if (type.equalsIgnoreCase("carrot")) {
			return new Carrot();
		}
		else {
			return null;
		}
	}
	

}
