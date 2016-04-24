package Simi;

import java.util.ArrayList;

import StemmingAlgorithm.Stemmer;

public class StemmingAlgorithm extends SimiAlgorithm{

	public StemmingAlgorithm(Article A, Article B) {
		super(A,B);	
	}

	@Override
	public String Compare() throws Exception {

		ArrayList<String> termsO = createStemmedTerms(original);
		ArrayList<String> termsR = createStemmedTerms(reference);
		int lengthO = original.getLength();
		int lengthR = reference.getLength();
		int count = 0;
		String result;

		for (String s : termsO)
			if (termsR.contains(s))
				count++;

		result = Double.toString((double) (count * 100) / ((lengthO + lengthR) / 2));

		return result;
	}

	public ArrayList<String> createStemmedTerms(Article article){
		ArrayList<String> stemmedTerms = new ArrayList<>();
		Stemmer stemmer;
		for(String s: article.getContent()){
			stemmer = new Stemmer();
			char[] term = s.toCharArray();
			stemmer.add(term, term.length);
			stemmer.stem();
			stemmedTerms.add(stemmer.toString());
		}
		return stemmedTerms;
	}
}
