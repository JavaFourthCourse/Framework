package framework;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Framework
{
	private final Map<String, MenuItem> menuItems;
	
	private static class Quit extends MenuItem
	{
		public Quit()
		{
			super("Выход", "q");
		}
		
		@Override
		public String doAction()
		{
			System.exit(0);
			
			return "";
		}
	}
	
	@SafeVarargs
	public <T extends MenuItem> Framework(Class<T>... menuItems) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
	{
		this.menuItems = new HashMap<>();
		
		for (Class<T> i : menuItems)
		{
			MenuItem menuItem = i.getConstructor().newInstance();
			
			this.menuItems.put(menuItem.getAccessCommand(), menuItem);
		}
		
		MenuItem quit = new Quit();
		
		this.menuItems.put(quit.getAccessCommand(), quit);
	}
	
	public String manageInput(String accessCommand)
	{
		return menuItems.get(accessCommand).doAction();
	}
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		while (true)
		{
			String accessCommand = scanner.next();
			
			System.out.println(this.manageInput(accessCommand));
		}
	}
}
