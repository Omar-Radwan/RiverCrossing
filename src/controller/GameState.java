package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import crossers.ICrossersFactory;
import crossers.interfaces.ICrosser;
import level.ICrossingStrategy;
import level.Level1Model;
import level.Level2Model;
import level.LevelFactory;

public class GameState {

	// main game parameters
	private List<ICrosser> crossersOnRightBank;
	private List<ICrosser> crossersOnLeftBank;
	private List<ICrosser> boatRiders;

	private boolean isBoatOnTheLeftBank;
	private int numberOfSails;

	private ICrossingStrategy gameStrategy;

	private LevelFactory levelFactory;
	private ICrossersFactory iCrossersFactory;

	public GameState() {
		crossersOnLeftBank = new LinkedList<ICrosser>();
		crossersOnRightBank = new LinkedList<ICrosser>();
		boatRiders = new LinkedList<ICrosser>();
		levelFactory = LevelFactory.getInstance();
		iCrossersFactory = ICrossersFactory.getInstance();
	}

	public Memento save() {
		return new Memento(crossersOnRightBank, crossersOnLeftBank, boatRiders, isBoatOnTheLeftBank, numberOfSails);
	}

	public void undo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
	}

	public void redo(Memento m) {
		boatRiders = m.getBoatRiders();
		crossersOnRightBank = m.getCrossersOnRightBank();
		crossersOnLeftBank = m.getCrossersOnLeftBank();
		numberOfSails = m.getNumberOfSails();
		isBoatOnTheLeftBank = m.isBoatOnTheLeftBank();
	}

	public List<ICrosser> getCrossersOnRightBank() {
		return crossersOnRightBank;
	}

	public void setCrossersOnRightBank(List<ICrosser> crossersOnRightBank) {
		this.crossersOnRightBank = crossersOnRightBank;
	}

	public List<ICrosser> getCrossersOnLeftBank() {
		return crossersOnLeftBank;
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

	public boolean isBoatOnTheLeftBank() {
		return isBoatOnTheLeftBank;
	}

	public void setBoatOnTheLeftBank(boolean isBoatOnTheLeftBank) {
		this.isBoatOnTheLeftBank = isBoatOnTheLeftBank;
	}

	public int getNumberOfSails() {
		return numberOfSails;
	}

	public void setNumberOfSails(int numberOfSails) {
		this.numberOfSails = numberOfSails;
	}

	public ICrossingStrategy getGameStrategy() {
		return gameStrategy;
	}

	public void setGameStrategy(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
	}

	// XML FUNCTIONS

	public void saveStateToXml() {

		String pathname = "unknownLevel.xml";

		if (gameStrategy instanceof Level1Model)
			pathname = "xmls/level1.xml";

		else if (gameStrategy instanceof Level2Model)
			pathname = "xmls/level2.xml";

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

	// should handle the exceptions in the view

	public void loadFromXml() {
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
			System.out.println(Double.parseDouble(iCrosserProperties.item(1).getTextContent()));
			iCrosser.setWeight(Double.parseDouble(iCrosserProperties.item(1).getTextContent()));
			iCrosser.setLabelToBeShown(iCrosserProperties.item(2).getTextContent());
			iCrosser.setNumber(Integer.parseInt(iCrosserProperties.item(3).getTextContent()));
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
		Element numberElement = document.createElement("number");

		Text typeText = document.createTextNode(iCrossersFactory.iCrosserType(iCrosser));
		Text weightText = document.createTextNode(Double.toString(iCrosser.getWeight()));
		Text labelToBeShownText = document.createTextNode(iCrosser.getLabelToBeShown());
		Text numberText = document.createTextNode(Integer.toString(iCrosser.getNumber()));

		typeElement.appendChild(typeText);
		weightElement.appendChild(weightText);
		labelToBeShownElement.appendChild(labelToBeShownText);
		numberElement.appendChild(numberText);

		iCrosserElement.appendChild(typeElement);
		iCrosserElement.appendChild(weightElement);
		iCrosserElement.appendChild(labelToBeShownElement);
		iCrosserElement.appendChild(numberElement);

		rootElement.appendChild(iCrosserElement);
	}

	// helping function to use in reset game
	private <T> void duplicateList(List<T> source, List<T> destination) {
		for (T x : source) {
			destination.add(x);
		}
	}

	public void reset() {
		System.out.println(gameStrategy.getInitialCrossers());
		duplicateList(gameStrategy.getInitialCrossers(), crossersOnRightBank);

		crossersOnLeftBank.clear();
		boatRiders.clear();

		isBoatOnTheLeftBank = false;
		numberOfSails = 0;
	}

	public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
		if (fromLeftToRightBank == true) {
			for (ICrosser x : crossers) {
				crossersOnLeftBank.remove(x);
			}

			if (gameStrategy.isValid(crossersOnRightBank, crossersOnLeftBank, crossers)) {

				return true;
			} else {
				for (ICrosser x : crossers) {
					crossersOnLeftBank.add(x);
				}
				return false;
			}

		}

		else {
			for (ICrosser x : crossers) {
				crossersOnRightBank.remove(x);
			}

			if (gameStrategy.isValid(crossersOnRightBank, crossersOnLeftBank, crossers)) {
				return true;
			} else {
				for (ICrosser x : crossers) {
					crossersOnRightBank.add(x);
				}
				return false;
			}
		}
	}

	public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

		if (fromLeftToRightBank) {
			for (ICrosser x : crossers) {
				crossersOnRightBank.add(x);
			}
			isBoatOnTheLeftBank = false;
		} else {
			for (ICrosser x : crossers) {
				crossersOnLeftBank.add(x);
			}
			isBoatOnTheLeftBank = true;
		}
		numberOfSails++;
	}

	public void newGame(ICrossingStrategy gameStrategy) {
		this.gameStrategy = gameStrategy;
		reset();
	}
}
