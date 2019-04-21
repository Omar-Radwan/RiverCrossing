package crossers.abstractclasses;

import java.awt.image.BufferedImage;

import crossers.ICrosser;

public abstract class Crosser implements ICrosser {

	protected boolean canSail;
	protected double weight;
	protected int eatingRank;
	protected BufferedImage[] images;

	public Crosser() {
		this.weight = 0 ;
	}

	@Override
	public boolean canSail() {
		return canSail;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEatingRank() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BufferedImage[] getImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ICrosser makeCopy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLabelToBeShown(String label) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getLabelToBeShown() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setWeight(double weight) {
		this.weight = weight;

	}

	@Override
	public void setImages(BufferedImage[] images) {
		this.images = images;

	}

	@Override
	public void setProperties(double weight, BufferedImage[] images) {
		setWeight(weight);
		setImages(images);
	}

}
