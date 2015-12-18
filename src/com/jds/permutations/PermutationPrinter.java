package com.jds.permutations;

public class PermutationPrinter {
    
    public void permutation(String perm, String input){
	if(input.isEmpty()){
	    System.out.println(perm+input);
	}else{
	    //keep a char in the first position, and do the permutations for the remaining characters
	    for(int i =0; i< input.length(); i++){
		//we fix a character in the first position
		permutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i+1, input.length()));
	    } 
	}
    }
    
    public void permutation(String word){
	permutation("", word);
    }
    
    
//    private String aggregatePermutation;
//    
//    public PermutationPrinter(){
//	this.aggregatePermutation = "";
//    }
//    
//    public void permutation(String input){
//	if(input.isEmpty()){
//	    System.out.println(getAggregatePermutation()+input);
//	    setAggregatePermutation("");
//	}else{
//	    //keep a char in the first position, and do the permutations for the remaining characters
//	    for(int i =0; i< input.length(); i++){
//		//we fix a character in the first position
//		setAggregatePermutation(getAggregatePermutation()+input.charAt(i));
//		permutation(input.substring(0, i) + input.substring(i+1, input.length()));
//	    } 
//	}
//    }
//    
//    public String getAggregatePermutation() {
//	return aggregatePermutation;
//    }
//
//    public void setAggregatePermutation(String aggregatePermutation) {
//	this.aggregatePermutation = aggregatePermutation;
//    }
}
