package CosineAlgorithm;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public final class StopwordList {
	//Words Ignored By Search Engines
	//refer to http://www.link-assistant.com/seo-stop-words.html
	
	public static StopwordList getInstance(){
		return stopwordList;
	}
	
	private static final StopwordList stopwordList = new StopwordList();
	private ArrayList<String> stopwords;
	
	private StopwordList() {
		try {
			stopwords = new ArrayList<>();
		    Scanner in = new Scanner(new File("stopwordList.txt"));
			String stopword;
			while (in.hasNext()) {
				stopword = in.next();
				stopwords.add(stopword);
			}
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getStopwords(){
		return stopwords;
	}
	
	public boolean isStopword(String s){
		for(String stopword: stopwords){
			if(s.equalsIgnoreCase(stopword))
				return true;
		}
		return false;		
	}
}
