

import java.io.FileNotFoundException;

import javax.xml.transform.TransformerException;

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
		try {
			Controller.saveGame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
