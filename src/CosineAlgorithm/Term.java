package CosineAlgorithm;

import Simi.Article;

public class Term implements Comparable<Term> {
	
	private double tfIdf;//edited
	private String text;
	
	public Term(String text, Article Base) throws Exception
	{
		this.text = text;
		double tf = Base.getTfOfText(text);
		double idf = IdfList.getInstance().getIdfOfText(text);
		this.tfIdf = tf*idf;
	}

	public double getTfIdf()
	{
		return tfIdf;
	}
	
	public String getText()
	{
		return text;
	}
	
	@Override
	public int compareTo(Term otherWord)
	{
		int tfidfOfOtherWord = (int) otherWord.getTfIdf();
		int tfidfOfThisWord = (int) this.tfIdf;
		return  tfidfOfThisWord - tfidfOfOtherWord;
	}

}
