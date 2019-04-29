package gui.related;

import java.util.ArrayList;
import java.util.Random;

import controller.ImageDetail;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Level1 extends IGameLevel {
	private Stage stage;
	// private Sprite[] objects = new Sprite[6];
	// Sprite temp = new Sprite();
	// private int score=0;
	static int objectNumber = 0;
	static int x;
	static ArrayList<Sprite> objects = new ArrayList<Sprite>();
	private Random rand = new Random();

	// private Image [] image = new Image[6];
	public Level1(ImageDetail[] imagesDetails) {

		objects.add(new Sprite(new Image("file:src/gui/related/background.jpg")));
		objects.add(new Sprite(new Image("file:src/gui/related/boat.jpg")));
		objects.get(1).setPositionX(500);
		objects.get(1).setPositionY(600);
		draw(imagesDetails);
		
		// hagib wolf bas not now w y add it here

	}
	public Level1() {
		
	}

	public void moveOnAction(GraphicsContext gc) {
		if (objects.get(1).getPositionX() == 500) {
			objects.get(1).addDeltaX(-350);
			objects.get(2).addDeltaX(-350);
			for (int j = 3; j < 6; j++) {
				if (objects.get(j).intersects(objects.get(1))) {
					objects.get(j).addDeltaX(-350);
				}
			}
			for (int i = 0; i < 6; i++) {
				objects.get(i).update();
				objects.get(i).render(gc);
			}
		} else {
			objects.get(1).addDeltaX(350);
			objects.get(2).addDeltaX(350);
			for (int j = 3; j < 6; j++) {
				if (objects.get(j).intersects(objects.get(1))) {
					objects.get(j).addDeltaX(350);
				}
			}
			for (int i = 0; i < 6; i++) {
				objects.get(i).update();
				objects.get(i).render(gc);
			}
		}
	}

	public int animationSet(GraphicsContext gc) {
		boolean flag1 = false;
		for (int k = 3; k < 6; k++) {
			if (objects.get(k).getPositionX() == 580 || objects.get(k).getPositionX() == 650
					|| objects.get(k).getPositionX() == 730) {
				if (objects.get(k).intersects(temp)) {
					if (objects.get(1).getPositionX() == 500) {
						for (int i = 3; i < 6; i++) {
							if (objects.get(i).getPositionX() == 620) {
								flag1 = true;
							}
						}
					}
				}
			}

		}

		for (int k = 3; k < 6; k++) {
			if (objects.get(k).getPositionX() == 620 && objectNumber != 0) {
				if (objects.get(k).getPositionX() == 620 && temp.intersects(objects.get(k))) {
					switch (k) {
					case 3:
						objects.get(k).setPositionX(580);
						objects.get(k).setPositionY(510);
						break;
					case 4:
						objects.get(k).setPositionX(650);
						objects.get(k).setPositionY(530);
						break;
					case 5:
						objects.get(k).setPositionX(730);
						objects.get(k).setPositionY(530);
						break;

					}
					for (int i = 0; i < 6; i++) {
						objects.get(i).update();
						objects.get(i).render(gc);
					}
					objectNumber = 0;

				}
			}
		}

		if (!flag1) {
			if (objectNumber != 0) {
				if (objects.get(1).getPositionX() == 500) {
					objects.get(objectNumber).setPositionX(620);
					objects.get(objectNumber).setPositionY(580);
					objectNumber = 0;
				} else if (objects.get(objectNumber).intersects(objects.get(1))) {
					switch (objectNumber) {
					case 3:
						objects.get(objectNumber).setPositionX(50);
						break;
					case 4:
						objects.get(objectNumber).setPositionX(1);
						break;
					case 5:
						objects.get(objectNumber).setPositionX(100);
						objects.get(objectNumber).setPositionY(500);
					}
					objectNumber = 0;
				} else
					objectNumber = 0;
				for (int i = 0; i < 6; i++) {
					objects.get(i).update();
					objects.get(i).render(gc);
				}

			}
		}

		for (int k = 3; k < 6; k++) {
			if (objects.get(k).getPositionX() == 50 || objects.get(k).getPositionX() == 1
					|| objects.get(k).getPositionX() == 100) {
				if (objects.get(k).intersects(temp)) {
					if (objects.get(1).getPositionX() == 150) {
						for (int i = 3; i < 6; i++) {
							if (objects.get(i).getPositionX() == 270) {
								x = 0;
								objectNumber = 0;
							}
						}
						if (x != 0) {
							objects.get(x).setPositionX(270);
							objects.get(x).setPositionY(580);
							objectNumber = 0;
							x = 0;
						}
					}
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			objects.get(i).update();
			objects.get(i).render(gc);
		}

		return objectNumber;

	}

	public void contGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeNewGame() {
		// TODO Auto-generated method stub

	}

	public void draw(ImageDetail[] imagesDetails) {

		Image images[] = new Image[6];

		for (int i = 2; i < 6; i++) {
			System.out.println(imagesDetails[i]);
			images[i] = SwingFXUtils.toFXImage(imagesDetails[i].getImage(), null);
			objects.add(new Sprite(images[i]));
		}

		if (imagesDetails[2].isOnLeft()) {
			objects.get(2).setPositionX(170);
			objects.get(2).setPositionY(570);
		}

		else {
			objects.get(2).setPositionX(520);
			objects.get(2).setPositionY(570);
		}

		if (imagesDetails[3].isOnLeft()) {
			objects.get(3).setPositionY(580);
			objects.get(3).setPositionX(50);
		}

		else {
			objects.get(3).setPositionX(580);
			objects.get(3).setPositionY(510);
		}

		if (imagesDetails[4].isOnLeft()) {
			objects.get(4).setPositionX(1);
			objects.get(4).setPositionY(580);
		}

		else {

			objects.get(4).setPositionX(650);
			objects.get(4).setPositionY(530);

		}

		if (imagesDetails[5].isOnLeft()) {
			objects.get(5).setPositionX(100);
			objects.get(5).setPositionY(500);
		} else {
			objects.get(5).setPositionX(730);
			objects.get(5).setPositionY(530);

		}

	}

}
