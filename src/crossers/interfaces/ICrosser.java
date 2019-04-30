package crossers.interfaces;

import java.awt.image.BufferedImage;

public interface ICrosser {

	public boolean canSail();

	public double getWeight();

	public int getEatingRank();

	public BufferedImage[] getImages();

	public ICrosser makeCopy();

	public void setLabelToBeShown(String label);

	public String getLabelToBeShown();

	public void setNumber(int number);

	public int getNumber();

	// added methods
	public void setWeight(double weight);
}
