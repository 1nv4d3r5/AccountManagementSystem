package businessLogic;

public interface EmployeeObserver {
	public void update(String name, BankEnum bank, double salary);
}
