package Moderate.AliveCount;

public class Person {
	
	public int birth;
	public int death;
	public Person(int birthYear, int deathYear) {
		birth = birthYear;
		death = deathYear;
		
	}
	public int getBirth() {
		return birth;
	}
	public int getDeath() {
		return death;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public void setDeath(int death) {
		this.death = death;
	}

}
