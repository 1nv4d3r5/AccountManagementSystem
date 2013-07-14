package businessLogic;

import database.EmployeeDB;

public class EmployeeBankFilter implements IEmployeeFilter{

	private int index;
	private BankEnum bank;
	private Employee employee;
	
	public EmployeeBankFilter(Employee employee, BankEnum bank) {
		this.bank = bank;
		this.employee = employee;
		index = 0;
	}
	
	
	@Override
	public boolean hasNext() {
		if(index == employee.getSubordinatesEmployees().size())
		{
			return false;
		}
		else
		{
			return true;
		}
	}

	@Override
	public Employee next() {
		Employee filterEmployee;
		try{
			filterEmployee = employee.getSubordinatesEmployees().get(index);
			index++;
			return filterEmployee;
		}
		catch(IndexOutOfBoundsException exc)
		{
			System.out.println("You traverse the whole list.");
			return null;
		}
	}

}
