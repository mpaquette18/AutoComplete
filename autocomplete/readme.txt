/******************************************************************************
 *  Name:Michael Paquette
 *
 *  Operating system:Mac OSX
 *  Compiler:Java 7
 *  Text editor / IDE:Eclipse
 *  Hours to complete assignment (optional):
 ******************************************************************************/


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
Sets ints low and high to each end of the array. Sets middle to be the (low + high)/2. While (low + 1)<high compare the middle to the key. 
If the key is less than or equal to the middle, update the high to be the middle, if the key is greater than the middle, update the low to be the middle. 
This will iterate so it goes to the first Index of the key, it checks Low first and then High and returns Low if the key matches and then if not it returns high. 
/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms N and the
 *  number of matching terms M?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower order terms, e.g., M^2 + M log N.
 *****************************************************************************/

constructor:MergeX sorts in LogN time. 

allMatches(): LogN + M

numberOfMatches(): LogN




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/




/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and exercises, but do
 *  include any help from people (including classmates and friends) and
 *  attribute them by name.
 *****************************************************************************/
Galbreith Williams


/******************************************************************************
 *  Describe any serious problems you encountered.
 *****************************************************************************/




/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 *****************************************************************************/
