
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;
import level.Level1Model;
import level.Level2Model;
import level.LevelFactory;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import com.sun.javafx.scene.traversal.WeightedClosestCorner;

import java.io.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import crossers.ICrossersFactory;
import crossers.concreteclasses.Carrot;
import crossers.concreteclasses.Farmer;
import crossers.concreteclasses.Goat;
import crossers.concreteclasses.Lion;
import crossers.concreteclasses.Sheep;
import crossers.concreteclasses.Wolf;

@XmlRootElement
public class RiverCrossingController implements IRiverCrossingController {

	// main game parameters
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private List<ICrosser> boatRiders;
	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;
	private ICrossingStrategy gameStrategy;

	// not sure if these must be included
	private int index = 0;

	// singleton
	private static RiverCrossingController instance;

	// factories
	private LevelFactory levelFactory;
	private ICrossersFactory iCrossersFactory;

	private RiverCrossingController() {

		crossersOnLeftBank = new LinkedList<ICrosser>();
		crossersOnRightBank = new LinkedList<ICrosser>();
		boatRiders = new LinkedList<ICrosser>();

		levelFactory = LevelFactory.getInstance();
		iCrossersFactory = ICrossersFactory.getInstance();

	};

	public static RiverCrossingController getInstance() {
		if (instance == null)
			instance = new RiverCrossingController();
		return instance;
	}

	public Memento save() {
		setIndex(getIndex() + 1);
		return new Memento(crossersOnRightBank, crossersOnLeftBank, boatRiders, isBoatOnTheLeftBank, numberOfSails);
	}

	@Override
	public void undo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
		setIndex(getIndex() - 1);
	}

	@Override
	public void redo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
		setIndex(getIndex() + 1);
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		resetGame();
	}

	@Override
	public void resetGame() {

		duplicateList(gameStrategy.getInitialCrossers(), crossersOnLeftBank);

		crossersOnRightBank.clear();
		boatRiders.clear();

		isBoatOnTheLeftBank = true;
		numberOfSails = 0;
	}

	// helping function to use in reset game
	private <T> void duplicateList(List<T> source, List<T> destination) {
		for (T x : source) {
			destination.add(x);
		}
	}

	@Override
	public String[] getInstructions() {
		return gameStrategy.getInstructions();
	}

	@Override
	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	@Override
	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
	}

	@Override
	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	@Override
	public int getNumberOfSails() {
		return numberOfSails;
	}

	public void setCrossersOnLeftBank(List<ICrosser> crossersOnLeftBank) {
		this.crossersOnLeftBank = crossersOnLeftBank;
	}

	public List<ICrosser> getBoatRiders() {
		return boatRiders;
	}

	public void setBoatRiders(List<ICrosser> boatRiders) {
		this.boatRiders = boatRiders;
	}

	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.crossersOnRightBank = crossersOnRightBank;
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}

	@Override
	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean canUndo() {
		if (index == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean canRedo(CareTaker T) {
		if (index == T.getSize() - 1)
			return false;
		else
			return true;
	}

	@Override
	public List<List<ICrosser>> solveGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ICrosser> getCrosserOnLeftBank() {
		return crossersOnLeftBank;
	}

	@Override
	public void saveGame() {

		String pathname = "unknownLevel.xml";

		if (gameStrategy instanceof Level1Model)
			pathname = "level1.xml";

		else if (gameStrategy instanceof Level2Model)
			pathname = "level2.xml";

		try {
			Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();

			Element levelDetailsElement = document.createElement("level-details");

			Element crossersOnRightBankElement = document.createElement("crossers-on-right-bank");
			listToElement(crossersOnRightBank, document, crossersOnRightBankElement);

			Element crossersOnLeftBankElement = document.createElement("crossers-on-left-bank");
			listToElement(crossersOnLeftBank, document, crossersOnLeftBankElement);

			Element boatRidersElement = document.createElement("boatriders");
			listToElement(boatRiders, document, boatRidersElement);

			Node isBoatOnLeftBankElement = document.createElement("is-boat-on-left-bank");
			Text isBoatOnLeftBankText = document.createTextNode(Boolean.toString(isBoatOnTheLeftBank));
			isBoatOnLeftBankElement.appendChild(isBoatOnLeftBankText);

			Node numberOfSailsElement = document.createElement("number-of-sails");
			Text numberOfSailsText = document.createTextNode(Integer.toString(numberOfSails));
			numberOfSailsElement.appendChild(numberOfSailsText);

			Node levelTypeElement = document.createElement("level-type");
			Text levelTypeText = document.createTextNode(levelFactory.levelType(gameStrategy));
			levelTypeElement.appendChild(levelTypeText);

			levelDetailsElement.appendChild(crossersOnRightBankElement);
			levelDetailsElement.appendChild(crossersOnLeftBankElement);
			levelDetailsElement.appendChild(boatRidersElement);

			levelDetailsElement.appendChild(isBoatOnLeftBankElement);
			levelDetailsElement.appendChild(numberOfSailsElement);
			levelDetailsElement.appendChild(levelTypeElement);

			document.appendChild(levelDetailsElement);

			try {
				Transformer t = TransformerFactory.newInstance().newTransformer();
				try {
					try {
						t.transform(new DOMSource(document), new StreamResult(new FileOutputStream(pathname)));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				} catch (TransformerException e) {
					e.printStackTrace();
				}

			} catch (TransformerConfigurationException e) {

				e.printStackTrace();
			} catch (TransformerFactoryConfigurationError e) {

				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void loadGame() {
		File file = new File(levelFactory.levelType(gameStrategy) + ".xml");
		try {

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document;
			try {
				document = documentBuilder.parse(file);
				NodeList nodeList = document.getChildNodes().item(0).getChildNodes();

				nodeListToList(nodeList.item(0).getChildNodes(), document, this.crossersOnRightBank);
				nodeListToList(nodeList.item(1).getChildNodes(), document, this.crossersOnLeftBank);
				nodeListToList(nodeList.item(2).getChildNodes(), document, this.boatRiders);

				this.isBoatOnTheLeftBank = Boolean.parseBoolean(nodeList.item(3).getTextContent());
				this.numberOfSails = Integer.parseInt(nodeList.item(4).getTextContent());
				this.gameStrategy = levelFactory.getLevel(nodeList.item(5).getTextContent());

			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

	}

	/// xml functions
	// format source , document , destination

	private void nodeListToList(NodeList nodeList, Document document, List<ICrosser> list) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			NodeList iCrosserProperties = nodeList.item(i).getChildNodes();
			ICrosser iCrosser = iCrossersFactory.getICrosser(iCrosserProperties.item(0).getTextContent());
			iCrosser.setWeight(Double.parseDouble(iCrosserProperties.item(1).getTextContent()));
			iCrosser.setLabelToBeShown(iCrosserProperties.item(2).getTextContent());

			list.add(iCrosser);
		}
	}

	private void listToElement(List<ICrosser> list, Document document, Element element) {
		for (ICrosser iCrosser : list) {
			iCrosserToElement(iCrosser, document, element);
		}

	}

	private void iCrosserToElement(ICrosser iCrosser, Document document, Element rootElement) {

		Element iCrosserElement = document.createElement("crosser");
		Element typeElement = document.createElement("type");
		Element weightElement = document.createElement("weight");
		Element labelToBeShownElement = document.createElement("label-to-be-shown");

		Text typeText = document.createTextNode(iCrossersFactory.iCrosserType(iCrosser));
		Text weightText = document.createTextNode(Double.toString(iCrosser.getWeight()));
		Text labelToBeShownText = document.createTextNode(iCrosser.getLabelToBeShown());

		typeElement.appendChild(typeText);
		weightElement.appendChild(weightText);
		labelToBeShownElement.appendChild(labelToBeShownText);

		iCrosserElement.appendChild(typeElement);
		iCrosserElement.appendChild(weightElement);
		iCrosserElement.appendChild(labelToBeShownElement);

		rootElement.appendChild(iCrosserElement);
	}

}
