package assignment1;
import java.util.Scanner;


//Assignment:  1. Explore the labels with break and continue in Loops

public class Q1 {
	public static void main(String []str)
	{
		int [][] arr = {{10, 20, 30, 40, 45, 50},{51, 60, 49, 70}};
		int j = 0;
		int prev = arr[0][0];
		label1:
			while(true)
			{
				
				for(int idx = 0; idx < arr[0].length; idx++)
				{
					
					if(arr[j][idx] < prev)
					{
						System.out.println("Breaking label1");
						 break label1;
					}
					
					else
					{
						
						System.out.println(arr[j][idx] + " >= " + prev);
						
					}
					prev = arr[j][idx];
				}
				
				j += 1;
				System.out.println("one row read");
			}
		Scanner pipe = new Scanner(System.in);
		
		label2:
			while(true)
			{
				
				int num = pipe.nextInt();
				
				if(num == 101 )
				{
					System.out.println("Exit Code Detected");
					break label2;
					
				}
				
				else if(num == 10)
				{
					
					System.out.println("Jumping to Label2");
					continue label2;
					
				}
				System.out.println("Didn't jump");
			}
		pipe.close();
	}

}
