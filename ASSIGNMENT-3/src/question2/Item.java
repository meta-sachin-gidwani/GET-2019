package question2;

public class Item {

	private int item;
	private int priority;

	public Item(int item, int priority) {
		this.item = item;
		this.priority = priority;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getItem() {
		return item;
	}

	public int getPriority() {
		return priority;
	}
}
