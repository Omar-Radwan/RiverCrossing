package controller.commands;

import controller.IRiverCrossingController;

public class SaveCommand implements Command {

	IRiverCrossingController Controller;

	public SaveCommand() {
	}

	public SaveCommand(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	public void setController(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	@Override
	public void execute() {
		Controller.saveGame();
	}
	
}
