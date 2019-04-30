package gui.related;

import javafx.geometry.Rectangle2D;
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

	public Sprite() {
		positionX = 0;
		positionY = 0;
	}

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

	public double getPositionX() {
		return positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void render(GraphicsContext gc) {
		gc.drawImage(image, positionX, positionY);

	}

	public void addDeltaX(int x) {
		this.deltaX = x;
	}

	public void addDeltaY(int y) {
		this.deltaY = y;
	}

	public void update() {

		this.positionX += deltaX;
		this.positionY += deltaY;
		deltaX = 0;
		deltaY = 0;

	}

	private Rectangle2D getBoundary() {
		return new Rectangle2D(positionX, positionY, width, height);
	}

	public boolean intersects(Sprite sprite) {
		return this.getBoundary().intersects(sprite.getBoundary());
	}

}
