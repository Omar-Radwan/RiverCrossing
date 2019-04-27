package xmlfiles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class XWriter {
	private Object objectToWrite;
	private String pathname;
	private Class<?> xClass;

	public XWriter(Object objectToWrite, String pathname, Class<?> xClass) {
		super();
		this.objectToWrite = objectToWrite;
		this.pathname = pathname;
		this.xClass = xClass;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public Class<?> getxClass() {
		return xClass;
	}

	public void setxClass(Class<?> xClass) {
		this.xClass = xClass;
	}

	public String getPath() {
		return pathname;
	}

	public void setPath(String path) {
		this.pathname = path;
	}

	public XWriter() {
		super();
	}

	public Object getObjectToWrite() {
		return objectToWrite;
	}

	public void setObjectToWrite(Object objectToWrite) {
		this.objectToWrite = objectToWrite;
	}

	public void write() throws IOException {
		StringWriter sw = new StringWriter();
		File file = new File(pathname);
		FileWriter x = new FileWriter(file);
		BufferedWriter br = new BufferedWriter(x);

		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(xClass);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.marshal(this.objectToWrite, sw);
			String xmlString = sw.toString();

			br.write(xmlString);
			sw.close();
			br.flush();
			br.close();

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

}
