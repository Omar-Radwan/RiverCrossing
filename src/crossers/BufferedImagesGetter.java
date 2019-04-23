package crossers;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class BufferedImagesGetter {

	private static BufferedImagesGetter instance;
	private HashMap<String, BufferedImage[]> bufferedImageMap;

	private BufferedImagesGetter() {
		bufferedImageMap = new HashMap<>();
	}

	public static BufferedImagesGetter getInstance() {
		if (instance == null) {
			instance = new BufferedImagesGetter();

		}
		return instance;
	}

	private void fillMap() {
		// code for filling the map with images
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
		return bufferedImageMap.get("carrot");
	}

}
