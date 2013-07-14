package businessLogic;
import java.util.Map;

import database.EmployeeDB;

public class CalculateSalary implements IExecutorCommand{
	@Override
	public void execute(String... args) {
		String id = args[0];
		Employee employee = EmployeeDB.idToEmployee.get(Integer.parseInt(args[0]));
		System.out.println(employee.calculateSalary());
	}

}
