import crossers.CrossersFactory;
import crossers.ICrosser;
import crossers.concreteclasses.Farmer;

public class Main {

	public static void main(String[] args) {

		CrossersFactory crossersFactory = new CrossersFactory();
		
		ICrosser f1 = crossersFactory.getCrosser("farmer");

		
	
		
	}

}
