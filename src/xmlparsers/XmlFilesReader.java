package xmlparsers;

import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class XmlFilesReader {

	private String filePath;

	public XmlFilesReader() {
		super();
	}

	public XmlFilesReader(String filePath) {
		super();
		this.filePath = filePath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Object readObject() {
		try {

			FileInputStream fis = new FileInputStream(new File(filePath));

			XMLDecoder decoder = new XMLDecoder(fis);

			return decoder.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
