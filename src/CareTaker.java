import java.util.ArrayList;

public class CareTaker {
	private ArrayList<Memento> mementos=new ArrayList <>();
	private static CareTaker instance;

	private CareTaker() {
	};

	public static CareTaker getInstance() {
		if (instance == null)
			instance = new CareTaker();
		return instance;
	}
	public int getSize()
	{
		return mementos.size();
	}
	public void addMemento(Memento M)
	{
		mementos.add(M);
	}
	public Memento getMemento()
	{
		RiverCrossingController r=RiverCrossingController.getInstance();
		Memento M=mementos.get(r.getIndex());
		return M;
	}
}
