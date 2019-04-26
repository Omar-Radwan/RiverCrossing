import java.util.ArrayList;

public class CareTaker {
	private ArrayList<Memento> mementos=new ArrayList <>();
	public void addMemento(Memento M)
	{
		mementos.add(M);
	}
	public Memento getMemento()
	{
		Memento M=mementos.get(mementos.size()-1);
		mementos.remove(mementos.size()-1);
		return M;
	}
}
