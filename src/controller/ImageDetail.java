package controller;
import java.awt.image.BufferedImage;

public class ImageDetail {

	boolean isOnLeft;
	BufferedImage image;

	public boolean isOnLeft() {
		return isOnLeft;
	}

	public void setOnLeft(boolean isOnLeft) {
		this.isOnLeft = isOnLeft;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public ImageDetail(boolean isOnLeft, BufferedImage image) {
		super();
		this.isOnLeft = isOnLeft;
		this.image = image;
	}

}
