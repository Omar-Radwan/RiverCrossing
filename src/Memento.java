

import java.util.List;

import crossers.interfaces.ICrosser;

public class Memento {
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private List<ICrosser> boatRiders;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;

	public Memento(List<ICrosser> crossersOnRightBank, List<ICrosser> crossersOnLeftBank, List<ICrosser> boatRiders,
			boolean isBoatOnTheLeftBank, int numberOfSails) {
		this.boatRiders = boatRiders;
		this.crossersOnLeftBank = crossersOnLeftBank;
		this.crossersOnRightBank = crossersOnRightBank;
		this.isBoatOnTheLeftBank = isBoatOnTheLeftBank;
		this.numberOfSails = numberOfSails;
	}

	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	public int getNumberOfSails() {
		return numberOfSails;
	}
}