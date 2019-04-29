

public class LoadCommand implements Command {

	IRiverCrossingController Controller;

	public LoadCommand() {
	}

	public LoadCommand(IRiverCrossingController Controller) {
		this.Controller = Controller;
	}

	@Override
	public void execute() {
		Controller.loadGame();

	}

}
