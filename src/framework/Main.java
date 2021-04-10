package framework;

import java.lang.reflect.InvocationTargetException;

import framework.tasks.Task1102;
import framework.tasks.Task425;
import framework.tasks.Task489;
import framework.tasks.Task549;
import framework.tasks.Task633;

public class Main
{
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
	{
		Framework framework = new Framework
				(
						new Task425(),
						new Task633(),
						new Task549(),
						new Task489(),
						new Task1102()
				);
		
		framework.run();
	}
}
