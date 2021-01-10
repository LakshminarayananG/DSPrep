package queue;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueImpl<T> implements Iterable<T> {
	
	LinkedList<T> list = new LinkedList<>();

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}

	/*
	 * enqueue, dequeue, peek, contains, isEmpty, size 
	 * 
	 * 
	 */
	
	public QueueImpl() {}
	public QueueImpl(T elem) {
		enqueue(elem);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size() == 0; 
	}
	
	public void enqueue(T elem) {
		list.addLast(elem);
	}
	
	public T dequeue() {
		if(isEmpty())
			throw new RuntimeException("The queue is empty; hence you cannot dequeue");
		return list.removeFirst();
	}
	
	public T peek() {
		if(isEmpty())
			throw new RuntimeException("The queue is empty; hence you cannot peek");
		return list.peekFirst();
	}
	
	public boolean contains(T elem) {
		return list.contains(elem);
	}
	
	
	// 77 = 13 = 2*13 + 1 => 2l+1
	
	
	
	
	
	
	
	
	
	
	
	
}
