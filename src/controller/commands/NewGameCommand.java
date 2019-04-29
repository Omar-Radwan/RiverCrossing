package controller.commands;

import controller.IRiverCrossingController;
import level.ICrossingStrategy;

public class NewGameCommand implements Command {

	IRiverCrossingController Controller;
	ICrossingStrategy gameStrategy;

	public NewGameCommand() {

	}

	public NewGameCommand(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	public void setController(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	@Override
	public void execute() {
		Controller.newGame(gameStrategy);

	}

}
