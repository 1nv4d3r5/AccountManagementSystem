package businessLogic;


import java.util.ArrayList;
import java.util.List;

public class Employee implements EmployeeObserverSubject{
	private String employeeName;
	private BankEnum bankName;
	private double salaryAmount;
	private List<Employee> subordinatesEmployees;
	private List<EmployeeObserver> observerList = new ArrayList<EmployeeObserver>();
	
	
	public Employee()
	{}
	
	public Employee(String name, BankEnum bank, double salary, List<Employee> subordinates)
	{
		this.employeeName = name;
		this.bankName = bank;
		this.salaryAmount = salary;
		this.subordinatesEmployees = subordinates;
	}
	
	public String getEmployeeName()
	{
		return this.employeeName;
	}
	
	public BankEnum getBankName()
	{
		return this.bankName;
	}
	
	public double getSalaryAmount()
	{
		return this.salaryAmount;
	}
	
	public List<Employee> getSubordinatesEmployees()
	{
		return this.subordinatesEmployees;
	}
	
	public List<EmployeeObserver> getEmployeeObservers()
	{
		return this.observerList;
	}
	
	public void setEmployeeName(String name)
	{
		this.employeeName = name;
		notifyObservers(name, this.bankName, this.salaryAmount);
	}
	
	public void setBankName(BankEnum bank)
	{
		this.bankName = bank;
		notifyObservers(this.employeeName, bank, this.salaryAmount);
	}
	
	public void setSalaryAmount(double salary)
	{
		this.salaryAmount = salary;
		notifyObservers(this.employeeName, this.bankName, salary);
	}
	
	public void setSubordinatesEmployees(List<Employee> subordinates)
	{
		this.subordinatesEmployees = subordinates;
	}
	
	public IEmployeeFilter interator() {
		return new EmployeeBankFilter(this, this.getBankName());
	}
	
	public double calculateSalary()
	{
		double calculatedSalary = this.getSalaryAmount();
		if(this.getSubordinatesEmployees() == null)
		{
			return calculatedSalary;
		}
		else
		{
			for (Employee employee : this.getSubordinatesEmployees()) {
				calculatedSalary += employee.getSalaryAmount();
				employee.calculateSalary();
			}
		}
		return calculatedSalary;
	}

	@Override
	public void registerObserver(EmployeeObserver observer) {
		observerList.add(observer);
		
	}

	@Override
	public void removeObserver(EmployeeObserver observer) {
		observerList.remove(observer);
		
	}

	@Override
	public void notifyObservers(String name, BankEnum bank, double salary) {
		System.out.println("Notifying to all observers");
		for(EmployeeObserver observer : observerList)
		{
			observer.update(name, bank, salary);
		}
		
	}
	
	
}
