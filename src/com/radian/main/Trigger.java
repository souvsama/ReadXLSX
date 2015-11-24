package com.radian.main;

import java.util.ArrayList;
import java.util.Iterator;

import com.radian.xlsx.ReadFile;
import com.radian.xml.ReadXML;

public class Trigger {

	public static void main(String[] args) {
		ArrayList<String> descriptionList = new ArrayList<String>();
		ArrayList<String> nameList = new ArrayList<String>();
		
		descriptionList = new ReadFile().fileElement();
		nameList = new ReadXML().getNameList();
		
		new Trigger().compare(descriptionList, nameList);

	}
	
	public void compare(ArrayList<String> descriptionList,ArrayList<String> nameList){
		Iterator<String> descriptionIterator = descriptionList.iterator();
		Iterator<String> nameIterator = nameList.iterator();
		String descriptor;
		String name;
		while (descriptionIterator.hasNext()) {
			boolean flag = true;
			descriptor = descriptionIterator.next();
			while(nameIterator.hasNext()){
				name = nameIterator.next();
				if(descriptor == name){
					flag = false;
					break;
				}
			}
			if(flag){
				System.out.println(descriptor);
			}			
		}
	}

}
