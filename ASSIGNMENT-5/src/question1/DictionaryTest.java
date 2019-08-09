package question1;
import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void sortingFullDictionaryTest() {
		Dictionary dictionary = new Dictionary("file.json");
		dictionary.addData(33, "follow");
		dictionary.addData(33, "sing");
		for(DataEntry entry : dictionary.getSortedList()) {
			System.out.println(entry);
		}
		System.out.println();
	}
	
	@Test
	public void sortingDictionaryInRangeTest() {
		Dictionary dictionary = new Dictionary("file.json");
		dictionary.addData(33, "follow");
		dictionary.addData(33, "sing");
		for(DataEntry entry : dictionary.getSubSortedList(2, 15)) {
			System.out.println(entry.getKey()+ "  "+entry.getValue());
		}
		System.out.println();
	}
	
	@Test
	public void getValueTest() {
		Dictionary dictionary = new Dictionary("file.json");
		assertEquals("vrinda",dictionary.getValue(6));
	}
	
	@Test
	public void keyNotFoundTest() {
		Dictionary dictionary = new Dictionary("file.json");
		assertEquals("key not found", dictionary.getValue(277));
	}
	
	@Test
	public void removeDataTest() {
		Dictionary dictionary = new Dictionary("file.json");
		dictionary.removeData(4);
		for(DataEntry entry : dictionary.getSortedList()) {
			System.out.println(entry);
		}
		System.out.println();
	}
}
