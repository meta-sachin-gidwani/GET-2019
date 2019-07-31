public class FindLoop {
	
	/**
	 * @param linked list
	 * @return true if list has loop else false
	 */
	public static boolean detectLoop(LinkedList list){
		Node node1=list.head;
		Node node2=list.head;
		while(node1!=null && node2!=null){
			//check for loop
			node2=node2.next;
			node1=node1.next.next;
			if(node1==node2)
				return true;
		}
		return false;
	}

}
