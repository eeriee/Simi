package Simi;

import java.util.HashSet;

public class SimpleAlgorithm extends SimiAlgorithm{
	
	//edited
	public SimpleAlgorithm(Article A, Article B){
		super(A,B);		
	}

	@Override
    public String Compare() throws Exception{

    	HashSet<String> termsO = new HashSet<>(original.getContent());
    	HashSet<String> termsR = new HashSet<>(reference.getContent());
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

}
