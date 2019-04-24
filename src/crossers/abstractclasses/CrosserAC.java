package crossers.abstractclasses;

import java.awt.image.BufferedImage;

import crossers.BufferedImagesGetter;
import crossers.ICrossersFactory;
import crossers.interfaces.ICrosser;

public abstract class CrosserAC implements ICrosser {

	protected boolean canSail;
	protected double weight;
	protected int eatingRank;
	protected BufferedImage[] images;
	protected BufferedImagesGetter bufferedImageFactory;
	protected ICrossersFactory crossersFactory;
	
	//msh3arf di al mfrod tb2a kda wla l2
	protected String labelToBeShown;

	public CrosserAC() {
		this.weight = 0;
		bufferedImageFactory = BufferedImagesGetter.getInstance();
		crossersFactory = ICrossersFactory.getInstance();
	}

	@Override
	public boolean canSail() {
		return canSail;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public int getEatingRank() {
		return this.eatingRank;
	}

	@Override
	public BufferedImage[] getImages() {
		return this.images;
	}

	@Override
	public void setLabelToBeShown(String label) {
		this.labelToBeShown = label;

	}

	@Override
	public String getLabelToBeShown() {
		return labelToBeShown;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;

	}

}
