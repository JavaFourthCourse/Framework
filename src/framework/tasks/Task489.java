package framework.tasks;

import framework.MenuItem;

public class Task489 extends MenuItem
{
	public Task489()
	{
		super("Решение задачи 489", "4");
	}
	
	@Override
	public String doAction()
	{
		return """
				import java.util.Scanner;
				import java.util.Locale;
				
				class program {
								
				    /**
				     * @param args the command line arguments
				     */
				    public static void main(String[] args) {
				        Scanner sc = new Scanner(System.in);
				        sc.useLocale(Locale.US);
				        String in = sc.nextLine();
				        String[] newLine = in.split("\\\\s+");
				        int c = 0;
				        for(String str: newLine){
				            int l = str.length() - 1;
				            if(str.charAt(0) == str.charAt(l)){
				                c++;
				            }
				        }
				        System.out.printf(Locale.US,"%d", c);
				        sc.close();           \s
				    }
				   \s
				}
				""";
	}
}
