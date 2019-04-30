package gui.related;

import java.util.LinkedList;
import java.util.List;

import crossers.interfaces.ICrosser;
import javafx.animation.AnimationTimer;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

public class Level1 extends Level {

	static int objectNumber = 0;
	static int x;

	int[] leftX = { 0, 0, 170, 50, 1, 100 };
	int[] rightX = { 0, 0, 520, 580, 650, 730 };

	int[] leftY = { 0, 0, 570, 580, 580, 500 };
	int[] rightY = { 0, 0, 570, 510, 530, 530 };

	public Level1() {
		objects = new Sprite[6];

		objects[0] = (new Sprite(new Image("file:src/gui/related/background.jpg")));
		objects[1] = (new Sprite(new Image("file:src/gui/related/boat.jpg")));

		// hagib wolf bas not now w y add it here
	}

	public void moveOnAction(GraphicsContext gc) {
		if (objects[1].getPositionX() == 500) {
			objects[1].addDeltaX(-350);
			objects[2].addDeltaX(-350);
			for (int j = 3; j < 6; j++) {
				if (objects[j].intersects(objects[1])) {
					objects[j].addDeltaX(-350);
				}
			}
			for (int i = 0; i < 6; i++) {
				objects[i].update();
				objects[i].render(gc);
			}
		} else {
			objects[1].addDeltaX(350);
			objects[2].addDeltaX(350);
			for (int j = 3; j < 6; j++) {
				if (objects[j].intersects(objects[1])) {
					objects[j].addDeltaX(350);
				}
			}
			for (int i = 0; i < 6; i++) {
				objects[i].update();
				objects[i].render(gc);
			}
		}
	}

	public int animationSet(GraphicsContext gc) {
		boolean flag1 = false;
		for (int k = 3; k < 6; k++) {
			if (objects[k].getPositionX() == 580 || objects[k].getPositionX() == 650
					|| objects[k].getPositionX() == 730) {
				if (objects[k].intersects(temp)) {
					if (objects[1].getPositionX() == 500) {
						for (int i = 3; i < 6; i++) {
							if (objects[i].getPositionX() == 620) {
								flag1 = true;
								objectNumber = 0;
							}
						}
					}
				}
			}

		}

		for (int k = 3; k < 6; k++) {
			if (objects[k].getPositionX() == 620 && objectNumber != 0) {
				if (objects[k].getPositionX() == 620 && temp.intersects(objects[k])) {
					switch (k) {
					case 3:
						objects[k].setPositionX(580);
						objects[k].setPositionY(510);
						break;
					case 4:
						objects[k].setPositionX(650);
						objects[k].setPositionY(530);
						break;
					case 5:
						objects[k].setPositionX(730);
						objects[k].setPositionY(530);
						break;

					}
					for (int i = 0; i < 6; i++) {
						objects[i].update();
						objects[i].render(gc);
					}
					objectNumber = 0;

				}
			}
		}

		if (!flag1) {
			if (objectNumber != 0) {
				if (objects[1].getPositionX() == 500) {
					objects[objectNumber].setPositionX(620);
					objects[objectNumber].setPositionY(580);
					objectNumber = 0;
				} else if (objects[objectNumber].intersects(objects[1])) {
					switch (objectNumber) {
					case 3:
						objects[objectNumber].setPositionX(50);
						break;
					case 4:
						objects[objectNumber].setPositionX(1);
						break;
					case 5:
						objects[objectNumber].setPositionX(100);
						objects[objectNumber].setPositionY(500);
					}
					objectNumber = 0;
				} else
					objectNumber = 0;
				for (int i = 0; i < 6; i++) {
					objects[i].update();
					objects[i].render(gc);
				}

			}
		}

		for (int k = 3; k < 6; k++) {
			if (objects[k].getPositionX() == 50 || objects[k].getPositionX() == 1 || objects[k].getPositionX() == 100) {
				if (objects[k].intersects(temp)) {
					if (objects[1].getPositionX() == 150) {
						for (int i = 3; i < 6; i++) {
							if (objects[i].getPositionX() == 270) {
								x = 0;
								objectNumber = 0;
							}
						}
						if (x != 0) {
							objects[x].setPositionX(270);
							objects[x].setPositionY(580);
							objectNumber = 0;
							x = 0;
						}
					}
				}
			}
		}
		for (int i = 0; i < 6; i++) {
			objects[i].update();
			objects[i].render(gc);
		}

		return objectNumber;

	}

	public void draw() {

		if (controller.isBoatOnTheLeftBank()) {
			objects[1].setPositionX(150);
			objects[1].setPositionY(600);
		} else {
			objects[1].setPositionX(500);
			objects[1].setPositionY(600);
		}
		for (ICrosser x : controller.getCrosserOnLeftBank()) {
			Image image = SwingFXUtils.toFXImage(x.getImages()[0], null);
			int indx = x.getNumber();
			objects[indx] = new Sprite(image);
			objects[indx].setPositionX(leftX[indx]);
			objects[indx].setPositionY(leftY[indx]);
		}

		for (ICrosser x : controller.getCrossersOnRightBank()) {

			Image image = SwingFXUtils.toFXImage(x.getImages()[0], null);
			int indx = x.getNumber();
			objects[indx] = new Sprite(image);
			objects[indx].setPositionX(rightX[indx]);
			objects[indx].setPositionY(rightY[indx]);

		}

		game();
		for (int i = 0; i < objects.length; i++) {
			System.out.println(objects[i]);
			objects[i].render(gc);
		}

		move.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				List<ICrosser> crossersOnBoat = new LinkedList<ICrosser>();

				for (int i = 2; i < 6; i++) {
					if (objects[i].intersects(objects[1])) {
						crossersOnBoat.add(getCrosserWithNumber(i));
						System.out.println(controller.getCrossersOnRightBank());
						System.out.println(controller.getCrosserOnLeftBank());
					}
				}

				if (controller.canMove(crossersOnBoat, controller.isBoatOnTheLeftBank())) {
					score++;
					updateScoreLabel();
					moveOnAction(gc);
				} else {
					System.out.println("errrrrrrrrrr");
				}

				if (controller.getCrosserOnLeftBank().size() == 4) {
					System.out.println("You Won");
				}

			}
		});

		new AnimationTimer() {

			@Override
			public void handle(long now) {
				objectNumber = animationSet(gc);
			}
		}.start();

		level.setOnMousePressed(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				temp.setPositionX(event.getX());
				temp.setPositionY(event.getY());

				for (int i = 3; i < 6; i++) {
					if (objects[i].intersects(temp)) {
						objectNumber = i;
						Level1.x = objectNumber;
					}
				}

			}

		});

	}

	public ICrosser getCrosserWithNumber(int n) {
		for (ICrosser x : controller.getCrosserOnLeftBank()) {
			if (x.getNumber() == n) {
				return x;
			}
		}

		for (ICrosser x : controller.getCrossersOnRightBank()) {
			if (x.getNumber() == n) {
				return x;
			}
		}
		return null;
	}

}
