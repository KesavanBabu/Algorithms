package Moderate.DivingBoard;

import java.util.ArrayList;
import java.util.HashSet;

// Problem
//I am building a diving board. There are two types of planks shorter and longer.
// I am allowed to use k planks of wood. Write a method to compute all possibilities lengths 


//Algorithm
//use recursion to find the possibilities
//1) get the inputs for the k value, shorter and longer length
//2) assign total possibilities as zero and create a function which recursively computes
//total value for all the k possibilities

public class DivingBoardPossibilities {
	
	public HashSet<Integer> getAllLengths(int k, int shorter, int longer) {
		
		HashSet<Integer> lengths = new HashSet<Integer>();
		
		computeTotalPossibilities(k,0, shorter, longer, lengths);
		
		return lengths;
				
	}
	
	public void computeTotalPossibilities(int k , int total, int shorter, 
			int longer, HashSet<Integer> lengths) {
		
		
		if(k == 0) {
			
			
			lengths.add(total);
			return;
		}
		
		computeTotalPossibilities(k-1, total + shorter, shorter, longer, lengths);
		computeTotalPossibilities(k-1, total + longer, shorter, longer, lengths);
	}

}

// complexity

//Improving using memoization
