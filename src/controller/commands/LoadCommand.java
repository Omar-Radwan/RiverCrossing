package controller.commands;

import controller.GameState;
import controller.commands.interfaces.Command;

public class LoadCommand implements Command {

	GameState gameState;

	public LoadCommand() {
	}

	public LoadCommand(GameState gameState) {
		this.gameState = gameState;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void execute() {
		gameState.loadFromXml();

	}

}
