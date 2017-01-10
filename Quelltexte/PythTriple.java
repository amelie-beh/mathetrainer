package MatheTrainer;

import java.util.ArrayList;
import java.util.List;

public class PythTriple {
	public int rndNumber;
	public int count = 0;
	
	public int u;
	public int v;
	
	public int x;
	public int y;
	public int z;
	
	List<Integer> numbers = new ArrayList<Integer>();
	
	List<Integer> X = new ArrayList<Integer>();
	List<Integer> Y = new ArrayList<Integer>();
	List<Integer> Z = new ArrayList<Integer>();

	
	public PythTriple(){
		
		for(int i = 0; i < 10; i++){
			numbers.add(i + 1);
		}
		
		for(int k = 0; k < numbers.size(); k++){
			v = numbers.get(k);
			
			for(int l = k +1; l < numbers.size(); l++){
				u = numbers.get(l);
				
				x = (int) (Math.pow(u, 2) - Math.pow(v, 2));
				y = 2*u*v;
				z = (int) (Math.pow(u, 2) + Math.pow(v, 2));
				
				X.add(x);
				Y.add(y);
				Z.add(z);
				
				count++;
			}
		}	
	}
	
	public void setRndNumber(int rndNumber){
		this.rndNumber = rndNumber;
	}
	public int getA(){
		return X.get(rndNumber);
	}
	public int getB(){
		return Y.get(rndNumber);
	}
	public int getC(){
		return Z.get(rndNumber);
	}
}
