//  Name: Tyler Davis
//  Class: CSE 271
//  Problem: P6.6
import java.util.Random;

public class P6_6 {	
	public static void main(String args[]){
		
		int[] num = new int[9];
		Random number = new Random();
		for(int i=0;i<num.length;i++) 
			num[i] = number.nextInt(20);
		int sum=0;
		for(int i=0;i<num.length;i++)
			if(i%2==0)
				sum+=num[i];
			else
				sum-=num[i];
		System.out.println("The alternating sum is: " +sum);
	}
}
