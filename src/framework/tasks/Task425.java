package framework.tasks;

import framework.MenuItem;

public class Task425 extends MenuItem
{
	public Task425()
	{
		super("Решение задачи 425", "3");
	}
	
	@Override
	public String doAction()
	{
		return """
				import java.util.Scanner;
				import java.util.Locale;
				import java.util.ArrayList;
				import java.util.List;
				import java.util.Collections;
				import static java.lang.Math.*;
				
				class program {
				    
				    /**
				     * @param args the command line arguments
				     */
				    public static void main(String[] args) {
				        Scanner sc = new Scanner(System.in);
				        sc.useLocale(Locale.US);
				        int n = sc.nextInt();
				        double arr[] = new double[n];
				        for(int i = 0; i < n; i++){
				            arr[i] = sc.nextDouble();
				        }
				        List<Double> list = new ArrayList<Double>();
				        int l = arr.length;
				        for(int i = 0; i < l; i++){
				            list.add(arr[i]);
				        }
				        double max = Collections.max(list);
				        if(Math.abs(max) > 1){
				            System.out.printf(Locale.US,"Yes");
				        }
				        else{
				            System.out.printf(Locale.US,"No");
				        }
				        sc.close();   \s
				       \s
				    }
				   \s
				}
				""";
	}
}
