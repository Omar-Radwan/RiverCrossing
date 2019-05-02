package controller.commands;

import controller.GameState;
import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;

public class ResetGameCommand implements Command {

	GameState gameState;

	public ResetGameCommand() {

	}

	public ResetGameCommand(GameState gameState) {
		this.gameState = gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void execute() {
		gameState.reset();

	}

}
