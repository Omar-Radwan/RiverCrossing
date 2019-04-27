package xmlparsers;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlFilesWriter {
	private Object objectToWrite;
	private String filePath;

	public XmlFilesWriter() {
	}

	public XmlFilesWriter(Object objectToWrite, String filePath) {
		super();
		this.objectToWrite = objectToWrite;
		this.filePath = filePath;
	}

	public Object getObjectToWrite() {
		return objectToWrite;
	}

	public void setObjectToWrite(Object objectToWrite) {
		this.objectToWrite = objectToWrite;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void writeObject() throws IOException {
		try {

			FileOutputStream fos = new FileOutputStream(new File(filePath));

			XMLEncoder encoder = new XMLEncoder(fos);

			encoder.writeObject(objectToWrite);

			encoder.close();
			fos.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
