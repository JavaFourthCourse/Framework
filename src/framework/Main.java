package framework;

import java.lang.reflect.InvocationTargetException;

public class Main
{
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException
	{
		Framework framework = new Framework();
		
		framework.run();
	}
}
