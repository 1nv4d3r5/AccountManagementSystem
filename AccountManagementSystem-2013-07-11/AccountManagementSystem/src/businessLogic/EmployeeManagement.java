package businessLogic;

import java.util.HashMap;
import java.util.Map;

public class EmployeeManagement {
	private Map<BankEnum, IBankConnector> bankTypeToConnector = new HashMap<BankEnum, IBankConnector>();
	
	private IBankConnector getBankConnector(BankEnum bank)
	{
		IBankConnector returnedBankConnector;
		if(bank.equals(BankEnum.DSK))
		{
			returnedBankConnector = new DskConnector();
			bankTypeToConnector.put(bank, returnedBankConnector);
			return returnedBankConnector;
		}
		else
		{
			returnedBankConnector = new FibankConnector();
			bankTypeToConnector.put(bank, returnedBankConnector);
			return returnedBankConnector;
		}
	}
	
	public void paySalary(Employee employee)
	{
		
	}
	
	public void paySubordinatesSalariesByBank(Employee employee, BankEnum bank)
	{
	}
}
