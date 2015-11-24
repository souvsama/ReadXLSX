package com.radian.hasmap.main;


import java.util.HashMap;
import java.util.Iterator;

import com.radian.hasmap.xlsx.ReadFile;
import com.radian.hasmap.xml.ReadXML;


public class Trigger {
	HashMap<String,String> changeList = new HashMap<String,String>();
	HashMap<String,String> newList = new HashMap<String,String>();

	public static void main(String[] args) {
		HashMap<String,String> descriptionList = new HashMap<String,String>();
		HashMap<String,String> nameList = new HashMap<String,String>();
		
		descriptionList = new ReadFile().fileElement();
		nameList = new ReadXML().getNameList();
/*		System.out.println("##########################");
		System.out.println("hhhh"+descriptionList.values());
		System.out.println("*********************");
		System.out.println(nameList);
		System.out.println("*********************");*/
		Trigger trigger = new Trigger();
		trigger.compare(descriptionList, nameList);
        trigger.output();		

	}
	
	public void compare(HashMap<String,String> descriptionList,HashMap<String,String> nameList){
		Iterator<String> descriptionIterator = descriptionList.keySet().iterator();
		Iterator<String> nameIterator = nameList.keySet().iterator();
		String descriptor;
		String name;
		int count =1;
		System.out.println("\n****************No Change List***************\n");
		while (descriptionIterator.hasNext()) {
			descriptor = descriptionIterator.next();
			while(nameIterator.hasNext()){
				name = nameIterator.next();
				if(descriptor.equalsIgnoreCase(name)){
                   if(descriptionList.get(descriptor).equalsIgnoreCase(nameList.get(name))){
                	   System.out.println(count+">  "+ descriptor.toLowerCase() +"   -->   "+descriptionList.get(descriptor) +"   **********Equal******   "+ nameList.get(name)+"\n");
                	   count++;
                	   break;
                   }else{
                	   //System.out.println(descriptor.toLowerCase() +"  --  Change the name with --->"+descriptionList.get(descriptor));
                	   //System.out.println("");
                	   changeList.put(descriptor.toLowerCase(), descriptionList.get(descriptor));
                   }
				}
			}
     	   //System.out.println(" ** "+descriptor.toLowerCase() +" -- New Entry on the XML File. Description --->"+descriptionList.get(descriptor));
           newList.put(descriptor.toLowerCase(), descriptionList.get(descriptor));		
		}
	}
	
	public void output(){
		Iterator<String> changeIterator = changeList.keySet().iterator();
		Iterator<String> newIterator = newList.keySet().iterator();
		int changeCount = 1;
		int newCount = 1;
		System.out.println("");
		System.out.println("\n******Change List****************");
		while (changeIterator.hasNext()) {
			String descriptor = changeIterator.next();
			System.out.println(changeCount+">  "+descriptor.toLowerCase() +"  --  Change the name with --->"+changeList.get(descriptor));
     	    System.out.println("");
     	    changeCount++;
		}
		System.out.println("\n");
		System.out.println("\n******New List****************");
		while (newIterator.hasNext()) {
			String descriptor = newIterator.next();
			System.out.println(newCount+">  "+descriptor.toLowerCase() +"  --  New Entry on the XML File. Description --->"+newList.get(descriptor));
     	    System.out.println("");
     	   newCount++;
		}
	}

}
