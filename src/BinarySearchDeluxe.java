import java.util.Comparator;

import edu.princeton.cs.algs4.MergeX;

public class BinarySearchDeluxe {

    // Returns the index of the first key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a==null||key==null||comparator==null){  //if any of the inputs are null throw exception
    		throw new java.lang.NullPointerException();
    	}
    	if (a.length == 0) {
    		return -1;
    	}
    	
    	int lo = 0;
    	int hi = a.length - 1;
    	int mid;
    	while (lo + 1 < hi) {  //binary search between lo and hi
    		mid = (lo + hi) /2;
    		if (comparator.compare(key, a[mid]) <= 0) {
    			hi = mid;
    		} else {
    			lo = mid;
    		}
    	}
    	if(comparator.compare(a[lo], key)==0){
    		return lo;
    	}
    	if(comparator.compare(a[hi], key)==0){
    		return hi;
    	}
    	
		return -1;
    	
    }

    // Returns the index of the last key in a[] that equals the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator){
    	if(a==null||key==null||comparator==null){
    		throw new java.lang.NullPointerException();
    	}

    	int lo = 0;
    	int hi = a.length - 1;
    	int mid;
    	while (lo + 1 < hi) {  //binary search between lo and hi
    		mid = (lo + hi)/2;
    		if (comparator.compare(key, a[mid]) >= 0) {
    			lo = mid;
    		} else {
    			hi = mid;
    		}
    	}
    	if(comparator.compare(a[hi], key)==0){
    		return hi;
    	}
    	
    	if(comparator.compare(a[lo], key)==0){
    		return lo;
    	}
    	
    
		return -1;

    	
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
        MergeX.sort(terms, Term.byPrefixOrder(4)); //byPrefixOrder(4) byReverseWeightOrder()
        /*
        for(int j=0;j<terms.length;j++){
        	System.out.println(terms[j].toString());
        }
        
        Term term1 = new Term("is rapid",100054);
        System.out.println(BinarySearchDeluxe.firstIndexOf(terms, term1, Term.byPrefixOrder(4)));
        System.out.println(BinarySearchDeluxe.lastIndexOf(terms, term1, Term.byPrefixOrder(4)));
        
        System.out.println(terms[BinarySearchDeluxe.firstIndexOf(terms, term1, Term.byPrefixOrder(4))]);
        System.out.println(terms[BinarySearchDeluxe.lastIndexOf(terms, term1, Term.byPrefixOrder(4))]);
        */
        
        Term[] tarma = new Term[8];
        tarma[0]=new Term("00000", 1);
        tarma[1]=new Term("11111", 2);
        tarma[2]=new Term("22222", 3);
        tarma[3]=new Term("33333", 4);
        tarma[4]=new Term("33333", 5);
        tarma[5]=new Term("33333", 8);
        tarma[6]=new Term("8888", 8);
        tarma[7]=new Term("9999", 8);
        Term test =new Term("33333", 3);
        System.out.println(BinarySearchDeluxe.firstIndexOf(tarma, test, Term.byPrefixOrder(4)));
        System.out.println(BinarySearchDeluxe.lastIndexOf(tarma, test, Term.byPrefixOrder(4)));
        
        System.out.println(tarma[BinarySearchDeluxe.firstIndexOf(tarma, test, Term.byPrefixOrder(4))].toString());
        System.out.println(tarma[BinarySearchDeluxe.lastIndexOf(tarma, test, Term.byPrefixOrder(4))].toString());
    }   
    
    
}