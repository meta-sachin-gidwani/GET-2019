public class LinkedList {

	Node head;

	/**
	 * @param list
	 * @param data
	 * @return Linked list with all the data inserted
	 */
	public LinkedList insert(LinkedList list, int data) {
		// object of type Node
		Node node = new Node(data);
		// if list is empty
		if (list.head == null)
			list.head = node;
		else {
			// finding last node
			Node last = list.head;
			while (last.next != null)
				last = last.next;
			// inserting node in the last
			last.next = node;
		}
		return list;
	}

	/**
	 * @param list to be rotated
	 * @param L starting index
	 * @param R ending index
	 * @param N number of rotation
	 */
	public static LinkedList rotate(LinkedList list, int L, int R, int N) {
		if (L < R) {
			if ((R - N) >= L) {
				// get previous of starting node of subList
				Node previousOfLNode = list.head;
				for (int i = 1; i < L - 1; i++)
					previousOfLNode = previousOfLNode.next;
				Node NpreviousOfRNode = list.head;
				// get node which is N number previous of end node of sublist
				for (int i = 1; i < R - N; i++)
					NpreviousOfRNode = NpreviousOfRNode.next;
				Node RNode = list.head;
				// get ending node of sublist
				for (int i = 1; i < R; i++)
					RNode = RNode.next;
				Node LNode = previousOfLNode.next;
				previousOfLNode.next = NpreviousOfRNode.next;
				NpreviousOfRNode.next = RNode.next;
				RNode.next = LNode;
				return list;
			} else if ((R - N + 1) == L)
				// if rotation gives same list
				return list;
			else {
				N = N - (R - L + 1);

				return rotate(list, L, R, N);
			}
		} else
			throw new AssertionError("L should be less than R");
	}

	/**
	 * @param list to be printed
	 */
	public void printList(LinkedList list) {
		Node currNode = list.head;
		// Traverse through the LinkedList
		while (currNode != null) {
			// Print the data at current node
			System.out.print(currNode.data + " ");
			// Go to next node
			currNode = currNode.next;
		}
	}
}
