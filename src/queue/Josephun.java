package queue;

import org.junit.Test;

public class Josephun {
	@Test
	public void test1(){
		
		int totalPeople = 41;
		lastAlive(totalPeople);
		
	}
	
	private void lastAlive(int n){		
		QueueImpl<Integer>  queue = new QueueImpl<>();		
		for (int i = 1; i <=n ; i++) {
			queue.enqueue(i);
		}
		
		while(queue.size()>1){
			int temp1 = queue.get(0);			
			queue.dequeue();
			queue.enqueue(temp1);
			queue.dequeue();		
		}
		
		System.out.println(queue.get(0));
		
	}


}
