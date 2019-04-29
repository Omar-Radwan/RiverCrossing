package gui.related;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Level2 extends IGameLevel {
	private Stage stage;
//private Sprite[] objects = new Sprite[7];
//private int weight = 0;
	static HBox menu = new HBox();
//private int score=0;
//Sprite temp = new Sprite();
	static ArrayList<Sprite> objects = new ArrayList<Sprite>();

	public Level2() {

		objects.add(new Sprite(new Image("file:src/gui/related/background.jpg")));
		objects.add(new Sprite(new Image("file:src/gui/related/boat2.png", 170, 170, false, false)));
		objects.add(new Sprite(new Image("file:src/gui/related/farmer1.png", 80, 80, false, false)));
		objects.add(new Sprite(new Image("file:src/gui/related/farmer3.png", 110, 110, false, false)));
		objects.add(new Sprite(new Image("file:src/gui/related/farmer2.png", 70, 70, false, false)));
		objects.add(new Sprite(new Image("file:src/gui/related/farmer4.png", 70, 70, false, false)));
		objects.add(new Sprite(new Image("file:src/gui/related/animallevel2.png", 70, 70, false, false)));

		objects.get(1).setPositionX(400);
		objects.get(1).setPositionY(500);
		objects.get(2).setPositionX(550);
		objects.get(2).setPositionY(500);
		objects.get(3).setPositionX(590);
		objects.get(3).setPositionY(510);
		objects.get(4).setPositionX(650);
		objects.get(4).setPositionY(510);
		objects.get(5).setPositionX(690);
		objects.get(5).setPositionY(540);
		objects.get(6).setPositionX(730);
		objects.get(6).setPositionY(580);

		Image image = new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/farmer1small.png", 30, 30,
				false, false);
		Label label = new Label("90kg");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		label.setGraphic(new ImageView(image));

		menu.setSpacing(2);
		menu.getChildren().add((label));

		Image image2 = new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/farmer3small.png", 30, 30,
				false, false);
		Label label2 = new Label("80kg");
		label2.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		label2.setGraphic(new ImageView(image2));

		menu.setSpacing(2);
		menu.getChildren().add((label2));

		Image image3 = new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/farmer2small.png", 30, 30,
				false, false);
		Label label3 = new Label("60kg");
		label3.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		label3.setGraphic(new ImageView(image3));

		menu.setSpacing(2);
		menu.getChildren().add((label3));

		Image image4 = new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/farmer4small.png", 30, 30,
				false, false);
		Label label4 = new Label("40kg");
		label4.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
		label4.setGraphic(new ImageView(image4));

		menu.setSpacing(10);
		menu.getChildren().add((label4));

	}

	static int objectNumber = 0;
	/*
	 * public NewLevel2(Stage stage1) { stage = stage1; }
	 * 
	 * 
	 * public void makeNewGame2() { double posX = 0.0; double posY = 0.0;
	 * 
	 * Group root = new Group(); Canvas canvas = new Canvas(800, 800);
	 * root.getChildren().add(canvas); GraphicsContext gc =
	 * canvas.getGraphicsContext2D(); objects[0] = new Sprite(new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/background.jpg"))
	 * ; objects[0].render(gc);
	 * 
	 * // boat objects[1] = new Sprite(new
	 * Image("file:///Users/esraayahia/git/RiverCrossing/src/gui/related/boat1.png",
	 * 170, 170, false, false)); objects[1].setPositionX(400);
	 * objects[1].setPositionY(500); objects[1].render(gc);
	 * 
	 * // first farmer 90kg objects[2] = new Sprite(new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer1.png", 80,
	 * 80, false, false)); objects[2].setPositionX(570);
	 * objects[2].setPositionY(500); objects[2].render(gc);
	 * 
	 * 
	 * // second farmer 80kg
	 * 
	 * objects[3] = new Sprite(new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer3.png",
	 * 110, 110, false, false)); objects[3].setPositionX(590);
	 * objects[3].setPositionY(510); objects[3].render(gc);
	 * 
	 * // third farmer 60kg objects[4] = new Sprite(new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer2.png", 70,
	 * 70, false, false)); objects[4].setPositionX(650);
	 * objects[4].setPositionY(510); objects[4].render(gc);
	 * 
	 * // fourth farmer 40kg objects[5] = new Sprite(new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer4.png", 70,
	 * 70, false, false)); objects[5].setPositionX(690);
	 * objects[5].setPositionY(540); objects[5].render(gc);
	 * 
	 * // horse animal
	 * 
	 * objects[6] = new Sprite(new
	 * Image("file:///Users/esraayahia/git/RiverCrossing/src/gui/related/horse.png",
	 * 70, 70, false, false)); objects[6].setPositionX(730);
	 * objects[6].setPositionY(580); objects[6].render(gc);
	 * 
	 * HBox menu = new HBox(4); ImageView move = new ImageView(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/doublearrow.png")
	 * ;
	 * 
	 * // moving Button moving = new Button("", move); move.setFitWidth(40);
	 * 
	 * move.setFitHeight(40); menu.getChildren().add(moving); //score label Label
	 * scorelabel = new Label(); scorelabel.setText("Score: " +score);
	 * //scorelabel.setFont(Font.font ("Verdana", 20));
	 * scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
	 * scorelabel.setTextFill(Color.BROWN);
	 * 
	 * menu.getChildren().add(scorelabel);
	 * 
	 * 
	 * 
	 * moving.setOnAction(new EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) {
	 * 
	 * 
	 * score ++; scorelabel.setText(Integer.toString(score));
	 * scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
	 * scorelabel.setTextFill(Color.BROWN);
	 * 
	 * scorelabel.setText("Score: " + score); if (objects.get(1).getPositionX() ==
	 * 400) {
	 * 
	 * objects.get(1).addDeltaX(-200);
	 * 
	 * for (int j = 1; j < 7; j++) { if (objects.get(j).intersects(objects.get(j)))
	 * { objects.get(j).addDeltaX(-200);
	 * 
	 * }
	 * 
	 * } for (int i = 0; i < 7; i++) { objects.get(i).update();
	 * objects.get(i).render(gc);
	 * 
	 * } }
	 * 
	 * else { objects.get(1).addDeltaX(200); for (int j = 1; j < 7; j++) { if
	 * (objects.get(j).intersects(objects.get(1))) { objects.get(j).addDeltaX(200);
	 * 
	 * } } for (int i = 0; i < 7; i++) { objects.get(i).update();
	 * objects.get(i).render(gc); } }
	 * 
	 * } });
	 */

// weight menu
	/*
	 * Image image = new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer1log.png",
	 * 30, 30, false, false); Label label = new Label("90kg");
	 * label.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
	 * label.setGraphic(new ImageView(image));
	 * 
	 * menu.setSpacing(2); menu.getChildren().add((label));
	 * 
	 * Image image2 = new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer3log.png",
	 * 30, 30, false, false); Label label2 = new Label("80kg");
	 * label2.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
	 * label2.setGraphic(new ImageView(image2));
	 * 
	 * menu.setSpacing(2); menu.getChildren().add((label2));
	 * 
	 * Image image3 = new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer2log.png",
	 * 30, 30, false, false); Label label3 = new Label("60kg");
	 * label3.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
	 * label3.setGraphic(new ImageView(image3));
	 * 
	 * menu.setSpacing(2); menu.getChildren().add((label3));
	 * 
	 * Image image4 = new Image(
	 * "file:///Users/esraayahia/git/RiverCrossing/src/gui/related/farmer4log.png",
	 * 30, 30, false, false); Label label4 = new Label("40kg");
	 * label4.setFont(Font.font("Verdana", FontWeight.BOLD, 10));
	 * label4.setGraphic(new ImageView(image4));
	 * 
	 * menu.setSpacing(10); menu.getChildren().add((label4));
	 * 
	 * Scene level2 = new Scene(root, 800, 800); level2.setOnMousePressed(new
	 * EventHandler<MouseEvent>() {
	 * 
	 * @Override public void handle(MouseEvent event) { // TODO Auto-generated
	 * method stub
	 * 
	 * temp.setPositionX(event.getX()); temp.setPositionY(event.getY()); for (int i
	 * = 2; i < 7; i++) { if (objects[i].intersects(temp)) { objectNumber = i;
	 * 
	 * } }
	 */
// System.out.println("X: " + event.getX() + " Y: " + event.getY());
	/*
	 * } });
	 * 
	 * 
	 * 
	 * root.getChildren().add(menu);
	 * 
	 * 
	 * new AnimationTimer() {
	 * 
	 * @Override public void handle(long arg0) {
	 * 
	 * if (objectNumber != 0) { if (objects[1].getPositionX() == 400) {
	 * objects[objectNumber].setPositionX(400);
	 * objects[objectNumber].setPositionY(500); objectNumber = 0;
	 * 
	 * } else if (objects[objectNumber].intersects(objects[1])) {
	 * 
	 * if(objectNumber==2) { objects[2].setPositionX(60);
	 * objects[2].setPositionY(581);
	 * 
	 * } if(objectNumber==3) { objects[3].setPositionX(50);
	 * objects[3].setPositionY(550);
	 * 
	 * } if(objectNumber==4) { objects[4].setPositionX(40);
	 * objects[4].setPositionY(570);
	 * 
	 * } if(objectNumber==5) { objects[5].setPositionX(30);
	 * objects[5].setPositionY(570);
	 * 
	 * } if(objectNumber==6) { objects[6].setPositionX(0);
	 * objects[6].setPositionY(570);
	 * 
	 * }
	 * 
	 * 
	 * } else if(objects[1].getPositionX() == 200) {
	 * objects[objectNumber].setPositionX(200);
	 * objects[objectNumber].setPositionY(500); objectNumber = 0; } else if(
	 * objects[objectNumber].intersects(objects[1])) { if(objectNumber==2) {
	 * objects[2].setPositionX(570); objects[2].setPositionY(500);
	 * 
	 * } if(objectNumber==3) { objects[3].setPositionX(590);
	 * objects[3].setPositionY(510);
	 * 
	 * } if(objectNumber==4) { objects[4].setPositionX(650);
	 * objects[4].setPositionY(510);
	 * 
	 * } if(objectNumber==5) { objects[5].setPositionX(690);
	 * objects[5].setPositionY(540);
	 * 
	 * } if(objectNumber==6) { objects[6].setPositionX(730);
	 * objects[6].setPositionY(580);
	 * 
	 * }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * for (int i = 0; i < 7; i++) { objects[i].update(); objects[i].render(gc); }
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * } }.start();
	 */

	/*
	 * new AnimationTimer() {
	 * 
	 * @Override public void handle(long arg0) { for (int k = 2; k < 7; k++) { if
	 * (objects[k].getPositionX() == 620) objectNumber = 0; } if (objectNumber != 0)
	 * { if (objects[1].getPositionX() == 400) {
	 * objects[objectNumber].setPositionX(400);
	 * objects[objectNumber].setPositionY(500); objectNumber = 0; } else if
	 * (objects[objectNumber].intersects(objects[1])) { boolean flag1=false; boolean
	 * flag2=false; for (int l = 2; l < 7; l++) { if (objects[l].getPositionX() ==
	 * 50) { flag1 = true; } else if (objects[l].getPositionX() == 0) { flag2 =
	 * true; } } if (!(flag1 || flag2)) objects[objectNumber].setPositionX(50); else
	 * if (flag1 && flag2 == false) objects[objectNumber].setPositionX(0); else {
	 * 
	 * objects[objectNumber].setPositionX(80);
	 * objects[objectNumber].setPositionY(500);
	 * 
	 * } objectNumber = 0; } else objectNumber = 0; for (int i = 0; i < 7; i++) {
	 * objects[i].update(); objects[i].render(gc); }
	 * 
	 * //check boat 3l shemal //
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * } }.start();
	 */

	/*
	 * 
	 * 
	 * stage.setScene(level2);
	 * 
	 * }
	 */

	@Override
	public void makeNewGame() {
// TODO Auto-generated method stub

	}

	@Override
	public void contGame() {
// TODO Auto-generated method stub

	}

	public void moveOnAction(GraphicsContext gc) {
		boolean flagMove = false;
		for (int j = 2; j < 7; j++) {
			if (objects.get(1).intersects(objects.get(j)))
				flagMove = true;
		}
		if (flagMove) {
			if (objects.get(1).getPositionX() == 400) {

				objects.get(1).addDeltaX(-200);

				for (int j = 1; j < 7; j++) {
					if (objects.get(j).intersects(objects.get(1))) {
						objects.get(j).addDeltaX(-200);

					}

				}
				for (int i = 0; i < 7; i++) {
					objects.get(i).update();
					objects.get(i).render(gc);

				}
			}

			else {
				objects.get(1).addDeltaX(200);
				for (int j = 1; j < 7; j++) {
					if (objects.get(j).intersects(objects.get(1))) {
						objects.get(j).addDeltaX(200);

					}
				}
				for (int i = 0; i < 7; i++) {
					objects.get(i).update();
					objects.get(i).render(gc);
				}
			}
		}
	}

	public int animationSet(GraphicsContext gc) {
		boolean flag1 = false;
		boolean flag2 = false;
		for (int k = 2; k < 7; k++) {
			if (objects.get(k).getPositionX() == 550 || objects.get(k).getPositionX() == 590
					|| objects.get(k).getPositionX() == 650 || objects.get(k).getPositionX() == 690
					|| objects.get(k).getPositionX() == 730) {
				if (objects.get(k).intersects(temp)) {
					if (objects.get(1).getPositionX() == 400) {
						for (int i = 2; i < 7; i++) {
							if (objects.get(i).getPositionX() == 400)
								flag1 = true;
							else if (objects.get(i).getPositionX() == 480)
								flag2 = true;
						}
					}
				}

			}
		}
		for (int k = 2; k < 7; k++) {
			if ((objects.get(k).getPositionX() == 400 || objects.get(k).getPositionX() == 480) && objectNumber != 0) {
				if ((objects.get(k).getPositionX() == 400 || objects.get(k).getPositionX() == 480)
						&& temp.intersects(objects.get(k))) {
					switch (k) {
					case 2:
						objects.get(2).setPositionX(550);
						objects.get(2).setPositionY(500);
						break;
					case 3:
						objects.get(3).setPositionX(590);
						objects.get(3).setPositionY(510);
						break;
					case 4:
						objects.get(4).setPositionX(650);
						objects.get(4).setPositionY(510);
						break;
					case 5:
						objects.get(5).setPositionX(690);
						objects.get(5).setPositionY(540);
						break;
					case 6:
						objects.get(6).setPositionX(730);
						objects.get(6).setPositionY(580);
						break;
					}

					for (int i = 0; i < 7; i++) {
						objects.get(i).update();
						objects.get(i).render(gc);
					}
					objectNumber = 0;
				}

			}
		}
		for (int k = 2; k < 7; k++) {
			if (objects.get(k).getPositionX() == 400) {
				flag1 = true;
			} else if (objects.get(k).getPositionX() == 480)
				flag2 = true;
		}
		if (flag1 == true && flag2 == true)
			objectNumber = 0;
		if (objectNumber != 0) {

			if (objects.get(1).getPositionX() == 400) {
				if (flag1 == false && flag2 == false) {
					objects.get(objectNumber).setPositionX(400);
					objects.get(objectNumber).setPositionY(500);
					objectNumber = 0;
				} else if (flag1 == true && flag2 == false) {
					objects.get(objectNumber).setPositionX(480);
					objects.get(objectNumber).setPositionY(500);
					objectNumber = 0;
				}

			} else if (objects.get(objectNumber).intersects(objects.get(1))) {

				switch (objectNumber) {
				case 2:
					objects.get(objectNumber).setPositionX(60);
					objects.get(objectNumber).setPositionY(581);
					break;
				case 3:
					objects.get(objectNumber).setPositionX(50);
					objects.get(objectNumber).setPositionY(550);
					break;
				case 4:
					objects.get(objectNumber).setPositionX(40);
					objects.get(objectNumber).setPositionY(570);
					break;
				case 5:
					objects.get(objectNumber).setPositionX(30);
					objects.get(objectNumber).setPositionY(570);
					break;
				case 6:
					objects.get(objectNumber).setPositionX(0);
					objects.get(objectNumber).setPositionY(570);
					break;
				}
				objectNumber = 0;

			} else if (objects.get(1).getPositionX() == 200) {
				objects.get(objectNumber).setPositionX(200);
				objects.get(objectNumber).setPositionY(500);
				objectNumber = 0;
			} else if (objects.get(objectNumber).intersects(objects.get(1))) {
				switch (objectNumber) {
				case 2:
					objects.get(2).setPositionX(570);
					objects.get(2).setPositionY(500);
					break;
				case 3:

					objects.get(3).setPositionX(590);
					objects.get(3).setPositionY(510);
					break;
				case 4:
					objects.get(4).setPositionX(650);
					objects.get(4).setPositionY(510);
					break;
				case 5:

					objects.get(5).setPositionX(690);
					objects.get(5).setPositionY(540);
					break;
				case 6:
					objects.get(6).setPositionX(730);
					objects.get(6).setPositionY(580);
					break;

				}

			}

			for (int i = 0; i < 7; i++) {
				objects.get(i).update();
				objects.get(i).render(gc);
			}

		}

		return objectNumber;
	}

}
