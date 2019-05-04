package gui.related;

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
	private Win win = new Win();
	private InvalidMove invalid = new InvalidMove();

	public Level1() {

		// al arrays di 3shan n3rf n3ml loop n8iar biha amaken al objects badal al
		// switch case
		rightX = new int[] { 0, 500, 520, 580, 650, 730 };
		rightY = new int[] { 0, 600, 570, 510, 530, 530 };
		leftX = new int[] { 0, 150, 170, 50, 1, 100 };
		leftY = new int[] { 0, 600, 570, 580, 580, 500 };

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
			/*
			 * for (int i = 0; i < 6; i++) { objects[i].update(); objects[i].render(gc); }
			 */
			updateAndRender();
		} else {
			objects[1].addDeltaX(350);
			objects[2].addDeltaX(350);
			for (int j = 3; j < 6; j++) {
				if (objects[j].intersects(objects[1])) {
					objects[j].addDeltaX(350);
				}
			}
			updateAndRender();
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

					objects[k].setPositionX(rightX[k]);
					objects[k].setPositionY(rightY[k]);

					/*
					 * for (int i = 0; i < 6; i++) { objects[i].update(); objects[i].render(gc); }
					 */
					updateAndRender();
					objectNumber = 0;

				}
			}
		}

		if (!flag1) {
			if (objectNumber != 0) {
				if (objects[1].getPositionX() == 500) {
					if (objects[objectNumber].getPositionX() == 50 || objects[objectNumber].getPositionX() == 1
							|| objects[objectNumber].getPositionX() == 100)
						objectNumber = 0;
					if (objectNumber != 0) {
						objects[objectNumber].setPositionX(620);
						objects[objectNumber].setPositionY(580);
						objectNumber = 0;
					}
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
				updateAndRender();
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

		updateAndRender();

		return objectNumber;

	}

	public void draw() {

		doTheCommonThingsInAllLevels();

		new AnimationTimer() {

			@Override
			public void handle(long now) {
				objectNumber = animationSet(gc);
			}
		}.start();

		move.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				List<ICrosser> crossersOnBoat = buildCrossersOnBoat();
				if (controller.canMove(crossersOnBoat, controller.isBoatOnTheLeftBank())) {
					controller.doMove(crossersOnBoat, controller.isBoatOnTheLeftBank());
					score++;
					updateScoreLabel();
					moveOnAction(gc);
					if (controller.getCrosserOnLeftBank().size() == 4   ) {

						win.display();

				
			}
								} 
				else {
					invalid.display();
				}


			}
		});

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

	// function btgeb al sowar bta3t al objecs mn al list of crossers al fl
	// controller
	// w btrsm kol crosser f al ganb al almfrod yb2a mwgod fih
	@Override
	public void setCrossersPositionsAndImages() {
		for (ICrosser x : controller.getCrosserOnLeftBank()) {
			Image image = SwingFXUtils.toFXImage(x.getImages()[0], null);
			int indx = x.getNumber();
			objects[indx] = new Sprite(image);
			objects[indx].setPositionX(leftX[indx]);
			objects[indx].setPositionY(leftY[indx]);
		}

		for (ICrosser x : controller.getCrossersOnRightBank()) {
			Image image = SwingFXUtils.toFXImage(x.getImages()[0], null);
			System.out.println(image.getHeight());
			System.out.println(image.getWidth());
			int indx = x.getNumber();
			objects[indx] = new Sprite(image);
			objects[indx].setPositionX(rightX[indx]);
			objects[indx].setPositionY(rightY[indx]);

		}
	}

}
