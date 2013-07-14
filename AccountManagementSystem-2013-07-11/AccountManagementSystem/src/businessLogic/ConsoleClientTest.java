package businessLogic;

import java.util.HashMap;
import java.util.Map;

public class ConsoleClientTest {
	private Map<String, IExecutorCommand> stringToCommand = new HashMap<String,IExecutorCommand>();
	IExecutorCommand command;
	
	public String[] getArgs(String command)
	{
		int i = command.indexOf(" ");
		String args[] = new String[2];
		args[0] = command.substring(i+1,i+2);
		i = command.indexOf(" ", i+1);
		if(i != -1)
		{
			args[1] = command.substring(i+1);
		}
		return args;
	}
	
	public void placeCommand(String command)
	{
		if(command.contains("paysalary"))
		{
			this.command = new PaySalary();
			stringToCommand.put(command, this.command);
			this.command.execute(getArgs(command));
			stringToCommand.remove(command);	
		}
		else if(command.contains("viewemployeelist"))
		{
			this.command = new ViewEmployeeAsList();
			stringToCommand.put(command, this.command);
			this.command.execute(getArgs(command));
			stringToCommand.remove(command);
		}
		else if(command.contains("calculatesalary"))
		{
			this.command = new CalculateSalary();
			stringToCommand.put(command, this.command);
			this.command.execute(getArgs(command));
			stringToCommand.remove(command);
		}
		else if(command.contains("paysubordinatessalariesbybank"))
		{
			this.command = new PaySubordinatesByBank();
			stringToCommand.put(command, this.command);
			this.command.execute(getArgs(command));
			stringToCommand.remove(command);
		}
		else if(command.contains("viewemployeeastable"))
		{
			this.command = new ViewEmployeeAsTable();
			stringToCommand.put(command, this.command);
			this.command.execute(getArgs(command));
			stringToCommand.remove(command);
		}
	}
}
