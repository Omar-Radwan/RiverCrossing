package controller;

import java.util.Stack;

public class CareTaker {

	// private ArrayList<Memento> mementos = new ArrayList<>();
	private static CareTaker instance;

	private Stack<Memento> undoStack = new Stack<Memento>();
	private Stack<Memento> redoStack = new Stack<Memento>();

	private CareTaker() {
	};

	public static CareTaker getInstance() {
		if (instance == null)
			instance = new CareTaker();
		return instance;
	}

	public void addMemento(Memento M) {

		undoStack.push(M);
	}

	public void resetUndoStack() {
		undoStack.clear();
	}

	public void resetRedoStack() {
		redoStack.clear();
	}

	public Memento undo(Memento m) {
		Memento M = undoStack.pop();
		redoStack.push(m);
		return M;
	}

	public Memento redo(Memento m) {
		Memento M = redoStack.pop();
		undoStack.push(m);
		return M;
	}
	public boolean isRedoStackEmpty()
	{
		return redoStack.isEmpty();
	}
	public boolean isUndoStackEmpty()
	{
		return undoStack.isEmpty();
	}
}
