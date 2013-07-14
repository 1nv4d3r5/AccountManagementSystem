package businessLogic;

public interface EmployeeObserverSubject {
	public void registerObserver(EmployeeObserver observer);
	public void removeObserver(EmployeeObserver observer);
	public void notifyObservers(String name, BankEnum bank, double salary);
}
