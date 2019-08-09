package question1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EmployeeCollection {
	
	//list of employee made using a set
	List<Employee> list=new ArrayList<Employee>();
	Set<Integer> set = new HashSet<Integer>();
	/**
	 * method adds employee to set
	 * @param empId of employee
	 * @param name of employee
	 * @param address of employee
	 */
	public void addEmployee(int empId, String name, String address) {
		Employee employee = new Employee(empId, name, address);
		// to check whether id is unique or not if id is unique add employee to set
		if(set.add(empId))
			list.add(employee);
	}
	
	public List<Employee> sortById(){
		Collections.sort(list, new SortById());
		return list;
	}
	
	public List<Employee> sortByName(){
		Collections.sort(list, new SortByName());
		return list;
	}
}
