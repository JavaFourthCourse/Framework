package framework.tasks;

import framework.MenuItem;

public class Task1102 extends MenuItem
{
	public Task1102()
	{
		super("Решение задачи 1102", "5");
	}
	
	@Override
	public String doAction()
	{
		return """
				import java.util.Scanner;
				import java.util.Locale;
				import static  java.lang.Math.*;
				
				class program {
				   \s
				    /**
				     * @param args the command line arguments
				     */
				    public static void main(String[] args) {
				        Scanner sc = new Scanner(System.in);
				        sc.useLocale(Locale.US);
				        int n = sc.nextInt();
				        double x = sc.nextDouble();
				        int num = 0, den = 0;
				        double min = 1000, tmpOne, tmpTwo, i , j;
				        for(i = 1; i <= n; ++i){
				            for (j = 2; j <= n; ++j){
				                if (i != j){
				                    tmpOne = i/j;
				                    tmpTwo = Math.abs(x - tmpOne);
				                    if(tmpTwo < min){
				                        min = tmpTwo;
				                        num = (int)i;
				                        den = (int)j;
				                    }
				                }
				            }
				        }
				        System.out.printf(Locale.US,"%d %d", num, den);
				        sc.close();
				    }
				   \s
				}
				""";
	}
}
