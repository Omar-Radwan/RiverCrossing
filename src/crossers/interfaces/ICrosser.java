package crossers.interfaces;
import java.awt.image.BufferedImage;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import crossers.abstractclasses.CrosserAC;


public interface ICrosser {

	public boolean canSail();
	public double getWeight();
	public int getEatingRank();
	public BufferedImage[] getImages();
	public ICrosser makeCopy();
	public void setLabelToBeShown(String label);
	public String getLabelToBeShown();

	// added methods
	public void setWeight (double weight);
}
