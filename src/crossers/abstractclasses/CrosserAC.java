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

	protected static BufferedImagesGetter bufferedImageFactory;
	protected static ICrossersFactory iCrossersFactory;
	
	protected int number;
	
	// msh3arf di al mfrod tb2a kda wla l2
	protected String labelToBeShown;

	public CrosserAC() {
		this.weight = 0;
		bufferedImageFactory = BufferedImagesGetter.getInstance();
		iCrossersFactory = ICrossersFactory.getInstance();
		this.labelToBeShown = "";
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

	public static void setICrosserFactory(ICrossersFactory iCrossersFactoryy) {
		iCrossersFactory = iCrossersFactoryy;
	}

	public boolean isCanSail() {
		return canSail;
	}

	public void setCanSail(boolean canSail) {
		this.canSail = canSail;
	}

	public BufferedImagesGetter getBufferedImageFactory() {
		return bufferedImageFactory;
	}

	public static void setBufferedImageFactory(BufferedImagesGetter bufferedImageFactory) {
		CrosserAC.bufferedImageFactory = bufferedImageFactory;
	}

	public static ICrossersFactory getiCrossersFactory() {
		return iCrossersFactory;
	}

	public static void setiCrossersFactory(ICrossersFactory iCrossersFactory) {
		CrosserAC.iCrossersFactory = iCrossersFactory;
	}

	public void setEatingRank(int eatingRank) {
		this.eatingRank = eatingRank;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
