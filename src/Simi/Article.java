package Simi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public  class Article {

	private ArrayList<String> content;
	private int length;
	
	public Article(String pathname) throws FileNotFoundException{
		content = new ArrayList<>(); 
	    Scanner in = new Scanner(new File(pathname));
	    while (in.hasNext()){
	    	String word = in.next().replaceAll("(?!')\\p{Punct}", "").toLowerCase(); //keep single quotes
	    	content.add(word);
	    }
	    length = content.size();
	    in.close();
	}	

	public int getLength() {
		return length;
	}
	
	public ArrayList<String> getContent(){
		
		return content;
	}
	
	public double getTfOfText(String text) // edited
	{
		double tf = ((double) Collections.frequency(this.content, text))/length;
		return tf;
	}
	
	public String getContentString(){
		
		String contentString;
		
	    contentString = content.toString();	
	
	    return  contentString ;
	}
}


	

