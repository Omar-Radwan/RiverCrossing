package crossers;
import java.awt.image.BufferedImage;

public interface ICrosser {

	public boolean canSail();
	public double getWeight();
	public int getEatingRank();
	public BufferedImage[] getImages();
	public ICrosser makeCopy();
	public void setLabelToBeShown(String label);
	public String getLabelToBeShown();
	
	
	// added functions 
	
	public void setWeight (double weight) ;
	public void setImages (BufferedImage [] images);
	public void setProperties (double weight , BufferedImage [] image);

	
}
