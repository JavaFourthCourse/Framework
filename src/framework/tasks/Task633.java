package framework.tasks;

import framework.MenuItem;

public class Task633 extends MenuItem
{
	public Task633()
	{
		super("Решение задачи 633", "1");
	}
	
	@Override
	public String doAction()
	{
		return """
                import java.util.Scanner;
                import java.util.Locale;
                
                class program {
                   \s
                    static long factorial(int n){
                        long res = 1;
                        for(int i = 0; i < n; i++){
                            res *= i;
                        }
                        return res;
                    }
                
                    /**
                     * @param args the command line arguments
                     */
                    public static void main(String[] args) {
                        Scanner sc = new Scanner(System.in);
                        sc.useLocale(Locale.US);
                        double x = sc.nextDouble();
                        double y = x;
                       \s
                        for(int i = 1; i <= 13; i++){
                            if(i == 3 || i == 7 || i == 11){
                                double tmp = Math.pow(x, i) / factorial(i);
                                y -= tmp;
                            }
                            else if (i == 5 || i == 9 || i == 13){
                                double tmp = Math.pow(x, i) / factorial(i);
                                y += tmp;
                            }
                        }
                        System.out.printf(Locale.US,"%.6f", y);
                        sc.close();           \s
                    }
                   \s
                }
                """;
	}
}
