package Lock.PrioritizedChopsticks;

public class Philosopher extends Thread {
	
	private int bites= 10;
	private Chopsticks lower, higher;
	private int index;
	
	public Philosopher(int i, Chopsticks left, Chopsticks right) {
		index = i;
		if(left.getNumber()< right.getNumber()){
			this.lower = left;
			this.higher = right;
		}else {
			this.lower = right;
			this.higher = left;
		}
	}
	
	public void pickup() {
		lower.pickUp();
		higher.pickUp();
	}
	
	public void putDown() {
		higher.putDown();
		lower.putDown();
	}
	
	public void chew() {
		// eat something
	}
	
	public void eat() {
		pickup();
		chew();
		putDown();
	}
	
	public void run() {
	for (int i=0; i < bites; i++) {
		eat();
	}
	}

}
