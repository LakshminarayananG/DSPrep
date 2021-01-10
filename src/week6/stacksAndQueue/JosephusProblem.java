package week6.stacksAndQueue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

//https://www.youtube.com/watch?v=uCsD3ZGzMgE&t=1s

public class JosephusProblem {

	@Test
	public void example1() {
		int i = 12;
		solveJosephus(i);
	}

	@Test
	public void example2() {
		int i = 41;
		solveJosephus(i);
	}

	@Test
	public void example3() {
		int i = 16;
		solveJosephus(i);
	}

	private void solveJosephus(int i) {
		QueueImpl<Integer> queue = new QueueImpl<>();

		for (int j = 1; j <= i; j++) {
			queue.enqueue(j);
		}

		while (queue.size() > 1) {
			int deq = queue.dequeue();
			queue.enqueue(deq);
			queue.dequeue();
		}

		System.out.println(queue.iterator().next());
	}

	private void solveJosephus1(int i) {
		int loop = (int) Math.floor(Math.sqrt(i));
		int n = 1;
		for (int j = 0; j < loop - 1; j++)
			n *= 2;

		System.out.println(2 * (i - n) + 1);
	}

}
