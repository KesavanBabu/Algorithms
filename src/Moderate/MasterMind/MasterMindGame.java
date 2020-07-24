package Moderate.MasterMind;

import java.util.HashSet;
import java.util.Set;

//Problem
//master mind is a game which gives four options RYGB which characters can be placed in any orders 
// The user can guess the four characters in the output. If any character matches, then hit is given
// If any character not matched, but still present in the output can be considered as pseudo hit

//Lets say RYGB is output, the guess is RRGG, two hits and two pseudo hits

//Algorithm
//1) Assign maxHit and pseudoMAxHot as zero. Assign integers for the codes.
//2) compare the guess and solution character wise. If matched, increment the max hit value
//Compute the characters which are unmatched in a set
//3) For Unmatched characters, check if present in set, increment the pseudo count, remove the 
//element from the set
public class MasterMindGame {
	
	int maxHits = 0;
	int pseudoMaxHits = 0;
	
	Set<Integer> s = new HashSet<Integer>();
	
	int code(char c) {
		switch (c) {
		case 'R':
			return 1;
			
		case 'Y':
			return 2;
			
		case 'G':
			return 3;
			
		case 'B':
			return 4;
			

		default:
			break;
		}
		return 0;
		
	}
	
	//compute the max hits
	public void computeMaxHits(String solution, String guess)
	{
		
		for (int i=0; i < guess.length(); i++){
			if(solution.charAt(i) == guess.charAt(i)) {
				maxHits ++;
			}else {
				int code = code(guess.charAt(i));
				s.add(code);
			}
		}
		computePseudoHits(solution, guess, s);
	}
	
	//compute pseudo hits
	public void computePseudoHits(String solution, String guess, Set<Integer> s) {
		
		for (int i=0; i < guess.length(); i++){
			if(solution.charAt(i) != guess.charAt(i) && s != null &&
					s.contains(code(guess.charAt(i)))) {
				pseudoMaxHits ++;
				s.remove(code(guess.charAt(i)));
			}
		}
	}
	
	
}

// complexity
// improvising measures
