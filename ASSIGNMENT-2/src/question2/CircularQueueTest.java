package question2;

import static org.junit.Assert.*;
import org.junit.Test;

public class CircularQueueTest {

	@Test
	public void queueTest() {
		CircularQueue queue = new CircularQueue(5);
		assertTrue(queue.isQueueEmpty());
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		assertTrue(queue.isQueueFull());
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		queue.print();
		assertFalse(queue.isQueueFull());
		assertFalse(queue.isQueueEmpty());
	}

}
