package Elevator;

import java.util.ArrayList;

import EventBarrier.Consumer;

public class testtest {

	public static ArrayList<String> stringList;
	
	public static void main(String[] input){
	
		stringList = new ArrayList<String>();
		
		for(int i =0; i<10; i++){
			String s = new String("adfadf");
			stringList.add(s);
		}
		
		System.out.print(stringList);
		
	}
	
	
}
