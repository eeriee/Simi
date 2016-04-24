package Simi;

import java.util.ArrayList;
import java.util.Collections;

import CosineAlgorithm.StopwordList;
import CosineAlgorithm.Term;

public class CosineAlgorithm extends SimiAlgorithm{

	public CosineAlgorithm(Article A, Article B) {
		
		super(A,B);
	}

	@Override
	public String Compare() throws Exception {

		ArrayList<String> keywords = new ArrayList<>();
		ArrayList<String> termsO = new ArrayList<>();
		ArrayList<String> termsR = new ArrayList<>();
		
///refactor - sissi
		termsO = createTerms(original);
		termsR = createTerms(reference);

		//first five words
		for (String termO: termsO)
		{
			boolean duplicate = false;
			for (String termR: termsR){
				if(termO.equals(termR))
					duplicate = true;	
			}
			if(!duplicate)
				keywords.add(termO);
		}
		
		for (String termR: termsR)
			keywords.add(termR);
		
		
		double[] vector1 = new double[keywords.size()];
		double[] vector2 = new double[keywords.size()];


		for (int i=0;i<keywords.size();i++)
		{
			vector1[i] = original.getTfOfText(keywords.get(i));
			vector2[i] = reference.getTfOfText(keywords.get(i));
		}
		
		double numerator;
		double denominator1,denominator2,result;
		numerator = 0;
		denominator1 = denominator2 = 0;
		for (int i=0;i<keywords.size();i++)
		{
			numerator += vector1[i]*vector2[i];
			denominator1 += vector1[i]*vector1[i];
			denominator2 += vector2[i]*vector2[i];
		}
		
		denominator1 = Math.sqrt(denominator1);
		denominator2 = Math.sqrt(denominator2);
		
		result = 100*numerator/(denominator1*denominator2);
					
		return Double.toString(result);
	}

	//Refactor - sissi
	public ArrayList<String> createTerms(Article article) throws Exception {
		boolean toAdd;
		ArrayList<Term> words = new ArrayList<>();
		for (String s : article.getContent()) {
			if (!StopwordList.getInstance().isStopword(s)) {
				toAdd = true;
				s = s.toLowerCase();
				Term word = new Term(s, article);
				for (Term w : words)
					if (word.getText().equals(w.getText()))
						toAdd = false;
				if (toAdd)
					words.add(word);
			}
		}
		Collections.sort(words);
		ArrayList<String> terms = new ArrayList<>();
		for (int i=0;i<5;i++)
		{
			terms.add(words.get(i).getText());
		}
		return terms;
	}
}
