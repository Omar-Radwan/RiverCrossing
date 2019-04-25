package gui.related;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Sprite {
	private Image image;
	private double positionX;
	private double positionY;
	private double width;
	private double height;
	private double deltaX;
	private double deltaY;

	public Sprite(Image image) {
		
		this.image = image;
		positionX = 0;
		positionY = 0;
		width = image.getWidth();
		height = image.getHeight();

	}
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(image, positionX, positionY);
		
		
	}
	
	

}
