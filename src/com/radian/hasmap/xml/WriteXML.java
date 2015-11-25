package com.radian.hasmap.xml;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class WriteXML {
	public void getNameList(HashMap<String,String> descriptionList){
		Iterator<String> descriptionIterator = descriptionList.keySet().iterator();
        try {	
           File inputFile = new File("E:/Java_Setup/Jars For xlsx file/TestTTX.xml");
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();
             NodeList nList = doc.getElementsByTagName("typecode");
             for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   String code = eElement.getAttribute("code");
                   String name = eElement.getAttribute("name");
                   while (descriptionIterator.hasNext()) {
           			String description = descriptionIterator.next();
           			String descriptionName = descriptionList.get(description);
           			if(description.equalsIgnoreCase(code) && !descriptionName.equalsIgnoreCase(name)){
           				eElement.setTextContent(descriptionName);
           			}
                   }                   
                }
             }
             
     		TransformerFactory transformerFactory = TransformerFactory.newInstance();
    		Transformer transformer = transformerFactory.newTransformer();
    		DOMSource source = new DOMSource(doc);
    		StreamResult result = new StreamResult(inputFile);
    		transformer.transform(source, result);

    		System.out.println("Done");
          } catch (Exception e) {
        	  System.out.println(e.getStackTrace());
          }
     }
}
