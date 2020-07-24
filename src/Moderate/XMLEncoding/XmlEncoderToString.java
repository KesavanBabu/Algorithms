package Moderate.XMLEncoding;

import org.w3c.dom.Element;

//Algorithm

public class XmlEncoderToString {
	
	String encodeToString(Element root) {
		
		StringBuilder sb = new StringBuilder();
		encode(root, sb);
		return sb.toString();
		
	}
	
	void encode(Element root, StringBuilder sb) {
		
		encode(root.getNodeName(), sb);
		
		if(root.getChildNodes() != null) {
			
			encode(root.getFirstChild().getNodeValue(), sb);
			
		}
		encode("0", sb);
	}
	
	void encode(String s, StringBuilder sb)
	{
		sb.append(s);
		sb.append(" ");
	}

}

///Complexity

//improvising measures
