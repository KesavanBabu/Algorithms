package Lock.PrioritizedChopsticks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopsticks {
	
	private Lock lock;
	private int number;
	
	
	public Chopsticks(int n){
		lock = new ReentrantLock();
		this.number = n;
		
	}
	
	public int getNumber() {
		return number;
	}
	
	public void pickUp(){
		lock.lock();
		
	}
	
	public void putDown() {
		lock.unlock();
	}
	

}
