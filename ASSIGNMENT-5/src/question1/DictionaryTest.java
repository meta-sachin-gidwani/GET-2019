package question1;
import static org.junit.Assert.*;

import org.junit.Test;

public class DictionaryTest {

	@Test
	public void sortingFullDictionaryTest() {
		Dictionary d = new Dictionary("file.json");
		d.addData(33, "follow");
		d.addData(33, "sing");
		for(DataEntry entry : d.getSortedList()) {
			System.out.println(entry);
		}
		System.out.println();
	}
	
	@Test
	public void sortingDictionaryInRangeTest() {
		Dictionary d = new Dictionary("file.json");
		d.addData(33, "follow");
		d.addData(33, "sing");
		for(DataEntry entry : d.getSortedList()) {
			System.out.println(entry.getKey()+ "  "+entry.getValue());
		}
		System.out.println();
	}
	
	@Test
	public void getValueTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("vrinda",d.getValue(6));
	}
	
	@Test
	public void keyNotFoundTest() {
		Dictionary d = new Dictionary("file.json");
		assertEquals("key not found",d.getValue(277));
	}
	
	@Test
	public void removeDataTest() {
		Dictionary d = new Dictionary("file.json");
		d.removeData(4);
		for(DataEntry entry : d.getSortedList()) {
			System.out.println(entry);
		}
		System.out.println();
	}
}
