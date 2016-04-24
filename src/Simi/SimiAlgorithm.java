package Simi;

public abstract class SimiAlgorithm {
	
	
	public  SimiAlgorithm(Article A, Article B){
		this.original=A;
		this.reference=B;
	}
	
	public abstract String Compare() throws Exception;
	
	protected Article original;
	protected Article reference;		   
    
}
