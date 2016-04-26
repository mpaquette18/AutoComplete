import java.util.Comparator;
import edu.princeton.cs.algs4.MergeX;

public class Term implements Comparable<Term> {
	String Query;
	long Weight;
	
	//static int R;
    // Initializes a term with the given query string and weight.
    public Term(String query, long weight){
if(query==null){
	throw new java.lang.NullPointerException("String cannot be null");
}
if (weight < 0) {
    throw new java.lang.IllegalArgumentException("weight < 0");
}
    	Query=query;
    	Weight=weight;
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder(){
 return new RWO();
    }
    
   private static class RWO implements Comparator<Term>{ // Compares the two terms in descending order by weight.

	
	public int compare(Term term1, Term term2) {
		if (term1.Weight > term2.Weight) {//if descending
	        return -1;
	    } else if (term1.Weight == term2.Weight) {//if equal
	        return 0;
	    } else {
	        return 1;//if ascending
	    }
	}
	   
   }
   

    // Compares the two terms in lexicographic order but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r){
    	
		return new PO(r);
    	
    }
    
    private static class PO implements Comparator<Term>{
        private int myR;
        
        public PO(int r) {
        	myR = r;
        }
        
        public int compare(Term t1, Term t2) {
            String s1 = t1.Query;
            String s2 = t2.Query;
            int minlength;
            
            if(s1.length()<s2.length()){ //find the smallest of the two strings
            	minlength=s1.length();
            }else{
            	minlength=s2.length();
            }
            
            if (minlength >= myR) { //if R is less than the minimum length use the substring (0, R) for each string and compareTo
                return s1.substring(0, myR).compareTo(s2.substring(0, myR));
            } else{
            	if (s1.substring(0, minlength).compareTo(s2.substring(0, minlength)) == 0) { //if the substrings are equal return the smaller one
                if (s1.length() == minlength){ 
                	return -1;
                	}
                else{ //return the smaller, s2
                	return 1;
                	}
            } else{ 
            	return s1.substring(0, minlength).compareTo(s2.substring(0, minlength));
            	}
            }
            	
        } 
    
    	
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that){
    	return (this.Query.compareTo(that.Query));	
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString(){
    	return Long.toString(Weight) + "	" + Query;
    }

    // unit testing (required)
    public static void main(String[] args){
    	 // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }
        MergeX.sort(terms, byPrefixOrder(2)); //byPrefixOrder(4) byReverseWeightOrder()
        for(int j=0;j<terms.length;j++){
        	System.out.println(terms[j].toString());
        }
        
    }   
} 
