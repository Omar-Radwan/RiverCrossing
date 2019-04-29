package controller.commands;

import controller.GameState;
import controller.commands.interfaces.Command;

public class SaveCommand implements Command {

	GameState gameState;

	public SaveCommand() {
	}

	public SaveCommand(GameState gameState) {
		this.gameState = gameState;
	}

	public void setController(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public void execute() {
		gameState.saveStateToXml();
	}

}
