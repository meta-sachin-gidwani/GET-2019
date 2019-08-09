package question1;

import org.junit.Test;

public class EmployeeCollectionTest {

	@Test
	public void SortByNametest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10, "Kalpna", "ABC");
		collection.addEmployee(3, "Vrinda", "ds");
		collection.addEmployee(4, "Sakshi", "SD");
		collection.addEmployee(4, "vaibhav", "SDC");
		collection.addEmployee(5, "sachin", "SDSC");
		collection.addEmployee(2, "mini", "qwe");
		for (Employee emp : collection.sortByName()) {
			System.out.println(emp);
		}
		System.out.println();
	}

	@Test
	public void SortByIdtest() {
		EmployeeCollection collection = new EmployeeCollection();
		collection.addEmployee(10, "Vrinda", "ABC");
		collection.addEmployee(3, "aVrinda", "ds");
		collection.addEmployee(4, "Sakshi", "SD");
		collection.addEmployee(4, "sachin", "SDC");
		collection.addEmployee(5, "sachin", "SDSC");
		collection.addEmployee(2, "mini", "qwe");
		for (Employee emp : collection.sortById()) {
			System.out.println(emp);
		}
		System.out.println();
	}

}
