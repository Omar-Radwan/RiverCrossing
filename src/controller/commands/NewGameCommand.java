package controller.commands;

import controller.commands.interfaces.Command;
import controller.interfaces.IRiverCrossingController;
import level.ICrossingStrategy;

public class NewGameCommand implements Command {

	IRiverCrossingController gameState;
	ICrossingStrategy gameStrategy;

	public NewGameCommand() {

	}

	public NewGameCommand(IRiverCrossingController Controller) {
		this.gameState = Controller;
	}

	public void setController(IRiverCrossingController Controller) {
		this.gameState = Controller;
	}

	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	@Override
	public void execute() {
		gameState.newGame(gameStrategy);

	}

}
