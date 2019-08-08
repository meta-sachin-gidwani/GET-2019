package question1;
import java.util.ArrayList;
import java.util.List;
public class BinaryTree {

	public Node root;
	//list for storing sorted tree
	private List<DataEntry> listOfSorted = new ArrayList<DataEntry>();
	//list for storing sorted tree in given range
	private List<DataEntry> listOfSortedInRange = new ArrayList<DataEntry>();

	public BinaryTree() {
		root = null;
	}

	/**
	 * @param root node of tree
	 * @param dataEntry: dictionary entry
	 * @return insert data in dictionary binary tree
	 */
	public Node insertData(Node root , DataEntry dataEntry){
		//if tree is empty
		if(root == null){
			root = new Node(dataEntry);
			return root;
		}
		//if key is less than root's key
		if(root.getEntry().getKey() > dataEntry.getKey()){
			root.setlChild(insertData(root.getlChild(),dataEntry));
		}
		//if key is greater than root's key
		else if(root.getEntry().getKey() < dataEntry.getKey()){
			root.setrChild(insertData(root.getrChild(),dataEntry))  ;
		}
		//if key is not unique
		else {
			return root;
		}
		return root;
	}

	public String searchKey(Node root, int key){
		//if key not found
		if(root == null){
			return "key not found";
		}
		//if key is found
		else if(root.getEntry().getKey() == key){
			return root.getEntry().getValue();
		}
		//if key is less than search in left subtree
		else if(root.getEntry().getKey() > key){
			return searchKey(root.getlChild(), key);
		}
		//if key is greater than search in right subtree
		else{
			return searchKey(root.getrChild(), key);
		}
	}

	/**
	 * method to sort tree
	 * @param root
	 */
	public List<DataEntry> sortDictionary(Node root){
		if (root != null) { 
			//sort left subtree
			sortDictionary(root.getlChild());
			//add root to list
			listOfSorted.add(root.getEntry());
			//sort right subtree
			sortDictionary(root.getrChild()); 
		} 
		return listOfSorted;
	}

	/**
	 * method sorts the element in given range
	 * @param root
	 * @param k1
	 * @param k2
	 */
	public List<DataEntry> sortSubDictionary(Node root, int k1,int k2){
		if (root != null) { 
			sortSubDictionary(root.getlChild(),k1,k2);
			if(root.getEntry().getKey()>=k1 && root.getEntry().getKey()<=k2){
				listOfSortedInRange.add(root.getEntry());
			}
			sortSubDictionary(root.getrChild(),k1,k2); 
		} 
		return listOfSortedInRange;
	}

	/**
	 * @param root
	 * @param key
	 * @return tree after deleting the node
	 */
	public Node deleteEntry(Node root, int key) { 
		//Base Case: If the tree is empty 
		if (root == null){
			return root; 
		}
		if (key < root.getEntry().getKey()) {
			root.setlChild(deleteEntry(root.getlChild(), key)); 
		}
		else if (key > root.getEntry().getKey()) {
			root.setrChild(deleteEntry(root.getrChild(), key)); 
		}
		// if key is found 
		else
		{   // node with only one child or no child 
			if (root.getlChild() == null) {
				return root.getrChild(); 
			}
			else if (root.getrChild() == null) {
				return root.getlChild(); 
			}
			// node with two children: Get the inorder successor (smallest  in the right subtree) 
			root.getEntry().setKey(minKey(root.getrChild())); 
			root.getEntry().setValue(minValue(root.getrChild())); 
			// Delete the inorder successor 
			root.setrChild(deleteEntry(root.getrChild(), root.getEntry().getKey()));
		} 
		return root; 
	} 

	/**
	 * @param root
	 * @return minimum key in right subtree
	 */
	public int minKey(Node root) { 
		int minKey = root.getEntry().getKey(); 
		while (root.getlChild() != null) { 
			minKey = root.getlChild().getEntry().getKey();
			root = root.getlChild(); 
		} 
		return minKey; 
	} 

	/**
	 * @param root
	 * @return minimum value in right subtree
	 */
	public String minValue(Node root) { 
		String minv = root.getEntry().getValue(); 
		while (root.getlChild() != null) { 
			minv = root.getlChild().getEntry().getValue();
			root = root.getlChild(); 
		} 
		return minv; 
	} 
}
