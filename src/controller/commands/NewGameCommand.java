package controller.commands;

import controller.GameState;
import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;
import level.ICrossingStrategy;

public class NewGameCommand implements Command {

	GameState gameState;
	ICrossingStrategy gameStrategy;

	public NewGameCommand() {

	}

	public NewGameCommand(GameState gameState) {
		this.gameState = gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public NewGameCommand(GameState gameState, ICrossingStrategy gameStrategy) {
		super();
		this.gameState = gameState;
		this.gameStrategy = gameStrategy;
	}

	@Override
	public void execute() {
		gameState.reset();

	}

	public ICrossingStrategy getGameStrategy() {
		return gameStrategy;
	}

	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	public GameState getGameState() {
		return gameState;
	}

}
