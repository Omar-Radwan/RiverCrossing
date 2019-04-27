package level;

public class LevelFactory {

	private static LevelFactory instance;

	private LevelFactory() {
	}

	public static LevelFactory getInstance() {
		if (instance == null) {
			instance = new LevelFactory();
		}
		return instance;
	}

	public LevelModel getLevel(String type) {
		if (type.equalsIgnoreCase("level1")) {
			return new Level1Model();
		} else if (type.equalsIgnoreCase("level2")) {
			return new Level2Model();
		}
		return null;
	}
}
