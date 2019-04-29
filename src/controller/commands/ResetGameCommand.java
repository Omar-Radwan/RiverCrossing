package controller.commands;

import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;

public class ResetGameCommand implements Command {

	IRiverCrossingController gameState;

	public ResetGameCommand() {

	}

	public ResetGameCommand(IRiverCrossingController gameState) {
		this.gameState = gameState;
	}

	public void setController(IRiverCrossingController gameState) {
		this.gameState = gameState;
	}

	@Override
	public void execute() {
		gameState.resetGame();

	}

}
