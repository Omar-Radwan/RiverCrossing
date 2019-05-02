package crossers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class BufferedImagesGetter {

	private static BufferedImagesGetter instance;
	private HashMap<String, BufferedImage[]> bufferedImageMap;

	private BufferedImagesGetter() {
		bufferedImageMap = new HashMap<>();
		fillMap();
	}

	public static BufferedImagesGetter getInstance() {
		if (instance == null) {
			instance = new BufferedImagesGetter();

		}
		return instance;
	}

	private void fillMap() {

		ArrayList<String> iCrossersTypes = new ArrayList<>();

		iCrossersTypes.add("farmer");

		iCrossersTypes.add("wolf");
		iCrossersTypes.add("lion");
		iCrossersTypes.add("sheep");

		iCrossersTypes.add("goat");
		iCrossersTypes.add("plant");
		iCrossersTypes.add("horse");

		for (String type : iCrossersTypes) {
			BufferedImage[] bufferedImages;

			if (type.equals("farmer")) {
				bufferedImages = new BufferedImage[5];
			} else {
				bufferedImages = new BufferedImage[2];
			}

			try {
				bufferedImages[0] = ImageIO.read(new File("src/gui/related/" + type + ".png"));
				if (type.equals("farmer")) {
					for (int i = 1; i <= 4; i++) {
						bufferedImages[i] = ImageIO.read(new File("src/gui/related/" + type + i + ".png"));
					}
				}
				// bufferedImages[1] = ImageIO.read(new File(type + "Reverse.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}

			bufferedImageMap.put(type, bufferedImages);
		}

	}

	public BufferedImage[] getFarmerImages() {
		return bufferedImageMap.get("farmer");
	}

	public BufferedImage[] getWolfImages() {
		return bufferedImageMap.get("wolf");
	}

	public BufferedImage[] getLionImages() {
		return bufferedImageMap.get("lion");
	}
	
	public BufferedImage[] getSheepImages() {
		return bufferedImageMap.get("sheep");
	}

	public BufferedImage[] getGoatImages() {
		return bufferedImageMap.get("goat");
	}

	public BufferedImage[] getCarrotImages() {
		return bufferedImageMap.get("plant");
	}

	public BufferedImage[] getHorseImages() {
		return bufferedImageMap.get("horse");	
	}

}
