package xmlfiles;
import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XReader {

	public XReader(String pathname, Class<?> xClass) {
		super();
		this.pathname = pathname;
		this.xClass = xClass;
	}

	private String pathname;
	private Class<?> xClass;

	public XReader() {
	}

	public String getPath() {
		return pathname;
	}

	public void setPath(String path) {
		this.pathname = path;
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

	
	public Object read() {
		File file = new File(pathname);
		Object object = null;
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(xClass);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			object = jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return object;
	}
	

}
