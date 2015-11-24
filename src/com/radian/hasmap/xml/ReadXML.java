package com.radian.hasmap.xml;

import java.io.File;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ReadXML {
	 
    public  HashMap<String,String> getNameList(){
    	HashMap<String,String> descriptionList = new HashMap<String,String>();
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
                   descriptionList.put(eElement.getAttribute("code"), eElement.getAttribute("name"));
                }
             }
          } catch (Exception e) {
        	  System.out.println(e.getStackTrace());
          }
    	 return descriptionList;
    }
}
