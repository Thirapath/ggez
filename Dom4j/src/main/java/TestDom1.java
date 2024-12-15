import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class TestDom1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File xml = new File("simple.xml");
		SAXReader reader = new SAXReader();
		Document doc = reader.read(xml);
		Element root = doc.getRootElement();
		
		Iterator i = root.elements().iterator();
		
		while(i.hasNext()) {
			
			Element e = (Element)i.next();
			System.out.println(e.getPath());
			System.out.println(e.getName());
			System.out.println(e.getData());
		}
	}

}
