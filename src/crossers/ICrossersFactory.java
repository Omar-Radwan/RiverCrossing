package crossers;

import java.util.Random;

import crossers.concreteclasses.Carrot;
import crossers.concreteclasses.Farmer;
import crossers.concreteclasses.Goat;
import crossers.concreteclasses.Horse;
import crossers.concreteclasses.Lion;
import crossers.concreteclasses.Sheep;
import crossers.concreteclasses.Wolf;
import crossers.interfaces.ICrosser;

public class ICrossersFactory {

	private static ICrossersFactory instance;

	private Random r;

	public ICrossersFactory() {
		r = new Random();
	}

	public static ICrossersFactory getInstance() {
		if (instance == null) {
			instance = new ICrossersFactory();
		}
		return instance;
	}

	public ICrosser getICrosser(String type) {

		if (type.equalsIgnoreCase("farmer")) {
			return new Farmer();
		} else if (type.equalsIgnoreCase("lion")) {
			return new Lion();
		} else if (type.equalsIgnoreCase("wolf")) {
			return new Wolf();
		} else if (type.equalsIgnoreCase("goat")) {
			return new Goat();
		} else if (type.equalsIgnoreCase("sheep")) {
			return new Sheep();
		} else if (type.equalsIgnoreCase("carrot")) {
			return new Carrot();
		} else if (type.equalsIgnoreCase("horse")) {
			return new Horse();
		} else {
			return null;
		}
	}

	public ICrosser getRandomCarnivorous() {

		String[] carnivorous = { "wolf", "lion" };
		int randomCarnivorousIndx = r.nextInt(carnivorous.length);
		return getICrosser(carnivorous[randomCarnivorousIndx]);
	}

	public ICrosser getRandomHerbivorous() {
		String[] herbivorous = { "sheep", "goat" };
		int randomHerbivorousIndx = r.nextInt(herbivorous.length);
		return getICrosser(herbivorous[randomHerbivorousIndx]);
	}

	public String iCrosserType(ICrosser iCrosser) {
		if (iCrosser instanceof Farmer) {
			return "Farmer";
		} else if (iCrosser instanceof Wolf) {
			return "Wolf";
		} else if (iCrosser instanceof Lion) {
			return "Lion";
		} else if (iCrosser instanceof Sheep) {
			return "Sheep";
		} else if (iCrosser instanceof Goat) {
			return "Goat";
		} else if (iCrosser instanceof Carrot) {
			return "Carrot";

		}
		else if (iCrosser instanceof Horse) {
			return "Horse";
		}
		return "";
	}

}
