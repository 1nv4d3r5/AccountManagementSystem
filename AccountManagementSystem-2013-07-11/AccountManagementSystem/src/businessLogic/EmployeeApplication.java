package businessLogic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import database.EmployeeDB;

public class EmployeeApplication {

	public static void main(String args[])
	{
		EmployeeDB employeeDB = new EmployeeDB();
		List<Employee> allEmployees = new ArrayList<Employee>();
		ConsoleClientTest commandPatternTest = new ConsoleClientTest();
		
		Scanner scr = new Scanner(System.in);
		
		ListViewEmployee listView = new ListViewEmployee("|", "_");
		
		EmployeeDB.idToEmployee.get(0).registerObserver(listView);
		
		System.out.println("Insert command");
		commandPatternTest.placeCommand(scr.nextLine());
		
	}
}
