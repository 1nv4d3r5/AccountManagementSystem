package businessLogic;

public class ListViewEmployee implements EmployeeObserver{

	private String verticalTableLayout;
	private String horizontalTableLayout;
	
	public ListViewEmployee(String vLayout, String hLayout)
	{
		this.verticalTableLayout = vLayout;
		this.horizontalTableLayout = hLayout;
	}
	
	public void setVerticalTableLayout(String vLayout)
	{
		this.verticalTableLayout = vLayout;
	}
	
	public String getVerticalTableLayout()
	{
		return verticalTableLayout;
	}
	
	public void setHorizontalTableLayout(String hLayout)
	{
		this.horizontalTableLayout = hLayout;
	}
	
	public String getHorizontalTableLayout()
	{
		return horizontalTableLayout;
	}
	
	@Override
	public void update(String name, BankEnum bank, double salary) {
		
		for(int i = 0; i<20; i++)
		{
			System.out.print(getHorizontalTableLayout());
		}
		System.out.println();
		System.out.println(getVerticalTableLayout() + name + getVerticalTableLayout() + bank.name() + getVerticalTableLayout() + salary + getVerticalTableLayout());
		for(int i = 0; i<20; i++)
		{
			System.out.print(getHorizontalTableLayout());
		}
	}

}
