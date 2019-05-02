package controller.commands;

import controller.CareTaker;
import controller.GameState;
import controller.commands.interfaces.Command;

public class RedoCommand implements Command {
	CareTaker careTaker;
	GameState gameState;

	public RedoCommand() {
	}

	public CareTaker getCareTaker() {
		return careTaker;
	}

	public void setCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	public RedoCommand(CareTaker careTaker, GameState gameState) {
		super();
		this.careTaker = careTaker;
		this.gameState = gameState;
	}

	@Override
	public void execute() {
		gameState.redo(careTaker.redo(gameState.save()));
	}

}
