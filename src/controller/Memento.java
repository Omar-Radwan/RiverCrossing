package controller;

import java.util.LinkedList;
import java.util.List;

import crossers.interfaces.ICrosser;

public class Memento {
	private List<ICrosser> crossersOnRightBank = new LinkedList<ICrosser>();
	private List<ICrosser> crossersOnLeftBank = new LinkedList<ICrosser>();
	private List<ICrosser> boatRiders = new LinkedList<ICrosser>();;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;

	
	public Memento(List<ICrosser> crossersOnRightBank , List<ICrosser> crossersOnLeftBank, List<ICrosser> boatRiders,
			boolean isBoatOnTheLeftBank, int numberOfSails) {
		
		duplicateList(crossersOnLeftBank, this.crossersOnLeftBank);
		duplicateList(crossersOnRightBank, this.crossersOnRightBank);
		duplicateList(boatRiders, this.boatRiders);
		this.numberOfSails = numberOfSails;
		this.isBoatOnTheLeftBank = isBoatOnTheLeftBank;
	
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

	private <T> void duplicateList(List<T> source, List<T> destination) {
		for (T x : source) {
			destination.add(x);
		}
	}
}