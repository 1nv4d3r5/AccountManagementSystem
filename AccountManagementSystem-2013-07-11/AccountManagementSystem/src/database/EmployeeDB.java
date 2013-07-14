package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import businessLogic.BankEnum;
import businessLogic.Employee;

public class EmployeeDB {
	public static Map<Integer, Employee> idToEmployee = new HashMap<Integer, Employee>();
	
	static{
		BankEnum bankDSK = BankEnum.DSK;
		BankEnum bankFIBANK = BankEnum.FIBANK;
		ArrayList<Employee> subordinates = new ArrayList<Employee>();
		Employee testEmployee = new Employee("Todor", bankDSK, 1000, null);
		Employee testEmployee1 = new Employee("Peter", bankFIBANK, 1000, null);
		Employee testEmployee2 = new Employee("Ivan", bankDSK, 1000, null);
		Employee testEmployee3 = new Employee("Stoyan", bankFIBANK, 1000, null);
		Employee testEmployee4 = new Employee("Dimiter", bankFIBANK, 1400, null);	
		subordinates.add(testEmployee1);
		subordinates.add(testEmployee2);
		subordinates.add(testEmployee3);
		subordinates.add(testEmployee4);
		testEmployee.setSubordinatesEmployees(subordinates);
		idToEmployee.put(0, testEmployee);
		idToEmployee.put(1, testEmployee1);
		idToEmployee.put(2, testEmployee2);
		idToEmployee.put(3, testEmployee3);
		idToEmployee.put(4, testEmployee4);
	}
	
	public List<Employee> getEmployeeDB()
	{
		List<Employee> employeeList = new ArrayList<Employee>();
		for(int i = 0; i< idToEmployee.size(); i++)
		{
			employeeList.add(idToEmployee.get(i));
		}
		return employeeList;
	}
	
	public Employee getEmployeeById(int employeeId)
	{
		return idToEmployee.get(employeeId);
	}
	
	public void insertEmployee(int id, Employee employee)
	{
		idToEmployee.put(id, employee);
	}
}
