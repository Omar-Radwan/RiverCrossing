package gui.related;

import java.util.ArrayList;
import java.util.Random;

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
	public Level1() {
		int ran1 = rand.nextInt(2);
		int ran2 = rand.nextInt(2);
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/background.jpg")));
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/boat.jpg")));
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/farmer.png")));
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/plant.png")));
		// if(ran1 == 0)
		objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/lion.png")));
		// else
		// hagib wolf bas not now w y add it here
		if (ran2 == 0)
			objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/src/gui/related/sheep.png")));
		else
			objects.add(new Sprite(new Image("file:///C:/Users/lenovo/git/RiverCrossing/goat.png")));
		// hagib b2a el goat
		objects.get(1).setPositionX(500);
		objects.get(1).setPositionY(600);
		objects.get(2).setPositionX(520);
		objects.get(2).setPositionY(570);
		objects.get(3).setPositionX(580);
		objects.get(3).setPositionY(510);
		objects.get(4).setPositionX(650);
		objects.get(4).setPositionY(530);
		objects.get(5).setPositionX(730);
		objects.get(5).setPositionY(530);

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

		} /*
			 * objects.get(1).setPositionX(400); objects.get(1).setPositionY(500);
			 * objects.get(2).setPositionX(550); objects.get(2).setPositionY(500);
			 * objects.get(3).setPositionX(590); objects.get(3).setPositionY(510);
			 * objects.get(4).setPositionX(650); objects.get(4).setPositionY(510);
			 * objects.get(5).setPositionX(690); objects.get(5).setPositionY(540);
			 * 
			 * 
			 * objects.get(6).setPositionX(730);
			 * 
			 * 
			 * objects.get(6).setPositionY(580);
			 */

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

		/* } */

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

	/*
	 * public void makeNewGame() { Label scorelabel = new Label();
	 * scorelabel.setText("Score: " +score); //scorelabel.setFont(Font.font
	 * ("Verdana", 20)); scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD,
	 * 15)); scorelabel.setTextFill(Color.BROWN); scorelabel.setLayoutX(350);
	 * scorelabel.setLayoutY(100);
	 * 
	 * double posX = 0.0; double posY = 0.0;
	 * 
	 * Group root = new Group(); Canvas canvas = new Canvas(800, 800);
	 * root.getChildren().add(canvas);
	 * 
	 * GraphicsContext gc = canvas.getGraphicsContext2D(); // object background
	 * objects[0] = new Sprite(new Image("file:background.jpg"));
	 * 
	 * objects[0].render(gc); // -------------------------------------
	 * 
	 * // boat object objects[1] = new Sprite(new Image("file:boat.jpg"));
	 * objects[1].setPositionX(500); objects[1].setPositionY(600);
	 * objects[1].render(gc); // ------------------------------- // farmer object
	 * objects[2] = new Sprite(new Image("file:farmer.png"));
	 * objects[2].setPositionX(520); objects[2].setPositionY(570);
	 * objects[2].render(gc); // -------------------------------------- // plant
	 * object objects[3] = new Sprite(new Image("file:plant.png"));
	 * objects[3].setPositionX(580); objects[3].setPositionY(510);
	 * objects[3].render(gc); // -------------------------------------------- //
	 * carni animal // el mafrod ha3mel random ya3ni bas lesa ama agib animal tany
	 * // ha3mel rand we law 0 yeb2a el object da lion // law 1 haykon el object da
	 * wolf same will go with herbi objects[4] = new Sprite(new
	 * Image("file:lion.png")); objects[4].setPositionX(650);
	 * objects[4].setPositionY(530); objects[4].render(gc);
	 * 
	 * // ---------------------------------------------- // herbi objects[5] = new
	 * Sprite(new Image("file:sheep.png")); objects[5].setPositionX(730);
	 * objects[5].setPositionY(530); objects[5].render(gc); //
	 * --------------------------------------------- // animation button : /* new
	 * AnimationTimer() {
	 * 
	 * @Override public void handle(long arg0) { objects[1].addDeltaX(300);
	 * objects[2].addDeltaX(-300); for(int i =0 ; i<6 ; i++) { objects[i].update();
	 * objects[i].render(gc); }
	 * 
	 * } };
	 */
	// --------------------------------------------
	// button move :
	/*
	 * Button move = new Button("Move"); move.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent event) { score ++;
	 * scorelabel.setText(Integer.toString(score));
	 * scorelabel.setFont(Font.font("Verdana", FontWeight.BOLD, 15));
	 * scorelabel.setTextFill(Color.BROWN);
	 * 
	 * scorelabel.setText("Score: " + score); if(objects[1].getPositionX() == 500){
	 * objects[1].addDeltaX(-350); objects[2].addDeltaX(-350); for (int j = 3; j <
	 * 6; j++) { if (objects[j].intersects(objects[1])) {
	 * objects[j].addDeltaX(-350); } } for (int i = 0; i < 6; i++) {
	 * objects[i].update(); objects[i].render(gc); } } else {
	 * objects[1].addDeltaX(350); objects[2].addDeltaX(350); for (int j = 3; j < 6;
	 * j++) { if (objects[j].intersects(objects[1])) { objects[j].addDeltaX(350); }
	 * } for (int i = 0; i < 6; i++) { objects[i].update(); objects[i].render(gc); }
	 * }
	 * 
	 * } });
	 */
	/*
	 * move.setStyle("-fx-font-size: 15pt;"); move.setLayoutX(380);
	 * move.setLayoutY(150); root.getChildren().add(scorelabel);
	 * root.getChildren().add(move); Scene level1 = new Scene(root, 800, 800);
	 * level1.setOnMousePressed(new EventHandler<MouseEvent>() {
	 * 
	 * @Override public void handle(MouseEvent event) { // TODO Auto-generated
	 * method stub temp.setPositionX(event.getX()); temp.setPositionY(event.getY());
	 * for (int i = 3; i < 6; i++) { if (objects[i].intersects(temp)) { objectNumber
	 * = i; } }
	 */

	/*
	 * for(int k = 3 ; k<6 ;k++) { if(k == objectNumber) continue; else
	 * if(objects[k].intersects(objects[objectNumber])) { objectNumber = 0; } }
	 */
	// System.out.println("X: " + event.getX() + " Y: " + event.getY());
	/*
	 * } });
	 */
	// if(objectNumber != 0) {
	// System.out.println("Hello");
	// new AnimationTimer() {
	@Override
	// public void handle(long arg0) {
	/*
	 * for(int k = 3 ; k<6 ;k++) { if(k == objectNumber) continue; else
	 * if(objects[k].intersects(objects[objectNumber])) { objectNumber = 0; } }
	 */
	/*
	 * for(int k =3 ;k<6; k++) { if(objects.get(k).getPositionX() == 620)
	 * objectNumber = 0; } if (objectNumber != 0 ) { if(objects[1].getPositionX() ==
	 * 500) { objects[objectNumber].setPositionX(620);
	 * objects[objectNumber].setPositionY(580); objectNumber = 0; } else
	 * if(objects[objectNumber].intersects(objects[1])){ boolean flag1 = false;
	 * boolean flag2 = false; for(int l =3 ; l<6 ; l++) {
	 * if(objects[l].getPositionX() == 50) { flag1 = true; } else if
	 * (objects[l].getPositionX()==0) { flag2 = true; } } if(!(flag1 || flag2))
	 * objects[objectNumber].setPositionX(50); else if (flag1 && flag2 == false)
	 * objects[objectNumber].setPositionX(0); else {
	 * objects[objectNumber].setPositionX(100);
	 * objects[objectNumber].setPositionY(500);
	 * 
	 * } objectNumber = 0; } else objectNumber = 0; for (int i = 0; i < 6; i++) {
	 * objects[i].update(); objects[i].render(gc); }
	 * 
	 * } } }.start(); // } stage.setScene(leSvel1);
	 * 
	 * }
	 */

	public void contGame() {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeNewGame() {
		// TODO Auto-generated method stub

	}

}
