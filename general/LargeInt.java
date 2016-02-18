package general;

import java.util.ArrayList;

/**
 * Class for huge integers. The integers are internally maintained in an ArrayList of integers between 0-9. 
 * Is used for Project Euler solutions, where the BigInteger class of Java is insufficient.
 * @author Kaspar Hageman 
 */
public class LargeInt {

	public ArrayList<Integer> ilist;
	
	public LargeInt(int n){
		ilist = new ArrayList<Integer>();
		
		int max_pow = (int) Math.floor(Math.log10(n));
		for (int i=max_pow; i >= 0; i--){
			int a = (int) Math.floor(n / Math.pow(10, i));
			n = n-(a*(int) Math.pow(10, i));
			ilist.add(a);			
		}		
	}
	
	public LargeInt(ArrayList<Integer> al){
		this.ilist = al;
	}
	
	/**
	 * Adds another integer to this integer.
	 * @param li - Large integer that is being added to this one.
	 */
	public void add(LargeInt li){
		ArrayList<Integer> ilist_other = li.ilist;
		int dlen = ilist.size() - ilist_other.size();	
		
		if (dlen > 0){ /* len(this) > len(other) */	
			for (int i= ilist_other.size()-1; i >= 0; i--){
				ilist.set(i+dlen, ilist.get(i+dlen) + ilist_other.get(i));
			}
		}	
		
		else if (dlen < 0){ /* len(this) < len(other) */		
			for (int i= ilist.size()-1; i >= 0; i--){
				ilist_other.set(i-dlen, ilist.get(i) + ilist_other.get(i-dlen));
			}			
			ilist = ilist_other;		
		}
		
		else { /* len(this) == len(other) */			
			for (int i = ilist.size()-1; i >= 0; i--){ /* from right to left */
				ilist.set(i, ilist.get(i) + ilist_other.get(i));
			}
		}
		normalise();
		
	}
	
	/**
	 *  Makes sure that every element in 'ilist' is 0-9. 
	 *  If higher, the previous index is incremented by 1, and the current value is decreased by 10. r
	 *  */
	private void normalise(){
		for (int i=ilist.size()-1; i>=0; i--){ /* from right to left */
			int val = ilist.get(i);
			if(val > 9){
				int a = (int) Math.floor(val / 10);				
				ilist.set(i, val-a*10); 
				
				if(i == 0){ /* unique case for i==0 */
					ilist.add(0, a);					
				}
				else {
					ilist.set(i-1, ilist.get(i-1)+a);
				}				
			}
		}
	}
	
	/**	   
	 * @return the number of digits of this integer.
	 */
	public int digits(){
		return ilist.size();
	}
	
	@Override
	public boolean equals(Object obj){
		if (obj == null){
			return false;
		}
		if (!LargeInt.class.isAssignableFrom(obj.getClass())){
			return false;
		}
		
		final LargeInt other = (LargeInt) obj;
		if (this.ilist.size() != other.ilist.size()) {
			return false;
		}
		for (int i = 0; i < ilist.size(); i++){
			if (ilist.get(i) != other.ilist.get(i)){
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString(){
		String r = "";
		for (int i=0; i<ilist.size(); i++){
			r += Integer.toString(ilist.get(i));
		}
		return r;
	}
	
	/**
	 * Creates a deep copy of this large integer
	 * @return copy of this.
	 */
	public LargeInt copy(){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i=0; i<ilist.size(); i++){
			al.add(ilist.get(i));
		}
		return new LargeInt(al);
	}
}