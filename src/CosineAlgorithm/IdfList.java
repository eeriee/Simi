package CosineAlgorithm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

public class IdfList {
	
	public static IdfList getInstance(){
		return idfList;
	}	

	private static final IdfList idfList = new IdfList();
	private HashMap<String, Double> idfListOfText;
	
	public IdfList(){	
		try {
			idfListOfText = new HashMap<>();
			BufferedReader br = new BufferedReader(
					new FileReader("idfList.txt"));
			String line;
			String[] strings;
			while ((line = br.readLine()) != null) {
				strings = line.split(" ");
				String text = strings[0];
				double idf = Double.parseDouble(strings[1]);
				idfListOfText.put(text, idf);
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isInIdfList(String text){
		if(idfListOfText != null && idfListOfText.containsKey(text))
			return true;
		return false;
	}
	
	public double getIdfOfText(String text) throws Exception
	{
		if(isInIdfList(text))
			return idfListOfText.get(text);
		else {
			String google = "http://www.google.com/search?q=";
			String search = text;
			String charset = "UTF-8";

			String userAgent = "ExampleBot 1.0 (+http://example.com/bot)";
			Elements div = Jsoup
					.connect(google + URLEncoder.encode(search, charset))
					.userAgent(userAgent).get().select("#resultStats");
			String[] results = div.toString().split(" ");
			double resultsCount = 0;
			for (int i = 0; i < results.length; i++) {
				if (results[i].contains("results")) {
					resultsCount = Double.parseDouble(results[i-1]
							.replaceAll(",", ""));
				}
			}
			double totalCount = Double.parseDouble("50000000000"); // modified
			double idf = Math.log(totalCount / (resultsCount + 1));
			PrintWriter out;
			out = new PrintWriter(new FileWriter("idfList.txt", true));
			out.println(text+" "+idf);
			out.close();
			idfListOfText.put(text, idf);
			return idf;
		}
	}
	
	
}
