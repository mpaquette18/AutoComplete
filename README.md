# AutoComplete
 A program to implement autocomplete for a given set of N terms, where a term is a query string and an associated nonnegative weight. 
 That is, given a prefix, find all queries that start with the given prefix, in descending order of weight.
Autocomplete is pervasive in modern applications. As the user types, the program predicts the complete query (typically a word or phrase),
that the user intends to type. Autocomplete is most effective when there are a limited number of likely queries. 
For example, the Internet Movie Database uses it to display the names of movies as the user types; search engines 
use it to display suggestions as the user enters web search queries; cell phones use it to speed up text input.

To Run this program, download this repository. Can be opened as an Eclipse project. 
The important files are in the "src" folder; Autocomplete.java, AutocompleteGUI.java, BinarySearchDeluxe.java, Term.java.
Before compiling these java files 
download algs4.jar from http://algs4.cs.princeton.edu/code/ 
download stdlib.jar from http://introcs.cs.princeton.edu/java/stdlib/
Autocomplete utilizes StdIn and StdOut from stdlib.jar, and MergeX from algs4.jar
