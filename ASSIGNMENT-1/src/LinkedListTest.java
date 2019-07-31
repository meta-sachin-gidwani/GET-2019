import static org.junit.Assert.*;
import org.junit.Test;

public class LinkedListTest {

	LinkedList list = new LinkedList();

	@Test
	public void rotateSublistWithSatisfiedCondition() {
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		list.printList(LinkedList.rotate(list, 2, 5, 2)); 
	}

	@Test(expected = AssertionError.class)
	public void rotateSublistWithoutSatisfiedCondition(){
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		LinkedList.rotate(list, 5,2,3);
	}

	@Test
	public void checkLoopTest() {
		list.insert(list, 2); 
		list.insert(list, 3); 
		list.insert(list, 4); 
		list.insert(list, 5); 
		list.insert(list, 6); 
		list.insert(list, 7); 
		assertFalse(FindLoop.detectLoop(list));
		list.head.next.next.next= list.head.next;
		assertTrue(FindLoop.detectLoop(list));
	}
}
