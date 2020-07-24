package Moderate.AliveCount;

//Given a list of people with birth and death years, Implement as solution to compute the 
//year with the most number of people alive. You may assume that all people were born between 1900 to 2000
//If a person is alive during certain portion of the year, then that year is also accounted.


//Algorithm:
//1) Assign maxAliveYear to min year value, alive count for an year to 0. set max and min values for the year
//2) based on the person birth and death year frm the person list, compute the number of years alive. set the value as 
//alive count
//3) check alive count with the computed count. If greater, assign it to the alive count and the 
//corresponding year.
//4) repeat the steps for all the person in the list for each year between the min and max years

public class FindMaxAliveYear {
	
	
	public int computeMaxAliveYear(Person[] p,int min, int max) {
		
		int maxAliveYear = min;
		int aliveCount = 0;

		for(int year= min; year<= max; year++) {
			int alive = 0;
			for (Person person: p) {

				if(person.getBirth() >= min && person.getDeath() <= max) {
					alive++;
				}

				if(alive > aliveCount) {
					aliveCount = alive;
					maxAliveYear = year;
				}
			}
		}
		
		return maxAliveYear;
	}
	
	// complexities
	
	//Improvising steps
	
	
	
	
	
	

}
