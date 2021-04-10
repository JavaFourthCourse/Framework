package framework;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
	
	private static class Help extends MenuItem
	{
		private static final String SEPARATION = "////////////////////////////////\n";
		
		private final List<MenuItem> items;
		private final String additionalDescription;
		
		public Help(Map<String, MenuItem> menuItems, String additionalDescription)
		{
			super("Подсказка", "h");
			
			items = new ArrayList<>();
			this.additionalDescription = additionalDescription;
			
			for (Map.Entry<String, MenuItem> i : menuItems.entrySet())
			{
				items.add(i.getValue());
			}
		}
		
		@Override
		public String doAction()
		{
			StringBuilder builder = new StringBuilder();
			
			builder.append(SEPARATION);
			
			builder.append(additionalDescription).append('\n');
			
			builder.append(getAccessCommand()).append(' ').append(getDescription()).append('\n');
			
			for (MenuItem i : items)
			{
				builder.append(i.toString()).append('\n');
			}
			
			builder.append(SEPARATION);
			
			return builder.toString();
		}
	}
	
	/**
	 * Очищает консоль, не работает в IDE
	 */
	private static class Clear extends MenuItem
	{
		Clear()
		{
			super("Очистить консоль", "cls");
		}
		
		@Override
		public String doAction()
		{
			try
			{
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			catch (IOException | InterruptedException e)
			{
				return "Не удалось очистить консоль";
			}
			
			return "Консоль очищена";
		}
	}
	
	private void addStandardMenuItems()
	{
		MenuItem tem = new Quit();
		
		menuItems.put(tem.getAccessCommand(), tem);
		
		tem = new Clear();
		
		menuItems.put(tem.getAccessCommand(), tem);
		
		tem = new Help(menuItems, "Приветствие");
		
		menuItems.put(tem.getAccessCommand(), tem);
	}
	
	public Framework(MenuItem... menuItems) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException
	{
		this.menuItems = new HashMap<>();
		
		for (MenuItem i : menuItems)
		{
			this.menuItems.put(i.getAccessCommand(), i);
		}
		
		this.addStandardMenuItems();
	}
	
	public String manageInput(String accessCommand)
	{
		return menuItems.get(accessCommand).doAction();
	}
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(this.manageInput("h"));
		
		while (true)
		{
			String accessCommand = scanner.next();
			
			System.out.println(this.manageInput(accessCommand));
		}
	}
}
