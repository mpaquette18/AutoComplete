import edu.princeton.cs.algs4.MergeX;

public class Autocomplete {
private Term[] termz;
    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms){
    	MergeX.sort(terms);
    	termz=terms;
    }

    // Returns all terms that start with the given prefix, in descending order of weight.
    public Term[] allMatches(String prefix){
    
    	Term[] matches;
    	Term test =new Term(prefix, 0);
    	int left = BinarySearchDeluxe.firstIndexOf(termz, test, Term.byPrefixOrder(prefix.length()));
    	int right = BinarySearchDeluxe.lastIndexOf(termz, test, Term.byPrefixOrder(prefix.length()));
    	int length = right -left +1;
    	if(left>0&&right>0&&left<right){
    		matches = new Term[length];
    		}else{
    			matches = new Term[0];
    			}
    	
    	if(matches.length!=0){
    		for(int i=0;i<length;i++){
    		matches[i]=termz[left+i];
    	}
    		}
    	
    	MergeX.sort(matches, Term.byReverseWeightOrder());
		return matches;}

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix){
    	Term test =new Term(prefix, 0);
    	int left = BinarySearchDeluxe.firstIndexOf(termz, test, Term.byPrefixOrder(prefix.length()));
    	int right = BinarySearchDeluxe.lastIndexOf(termz, test, Term.byPrefixOrder(prefix.length()));
    	int length = right -left +1;
		return length;}

    public static void main(String[] args) {

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

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }

}