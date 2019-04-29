package controller.commands;

import controller.IRiverCrossingController;

public class ResetGameCommand implements Command {

	IRiverCrossingController Controller;

	public ResetGameCommand() {

	}

	public ResetGameCommand(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	public void setController(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	@Override
	public void execute() {
		Controller.resetGame();

	}

}
