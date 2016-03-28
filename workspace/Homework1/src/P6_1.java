//  Name:Tyler Davis
//  Class:  CSE 271
//  Problem: P6.1
import java.util.Random;

public class P6_1 {
	public static void main(String args[]) {
		
		int[] num = new int[9];
		Random number = new Random();
		for(int i=0;i<num.length;i++)
			num[i] = number.nextInt(100);
		
		System.out.println("Even Indexes:");
		for(int i=0;i<num.length;i+=2)
			System.out.println(num[i]);
		
		System.out.println("\nEven elements:");
		for(int i=0;i<num.length;i++)
			if(num[i]%2==0)
				System.out.println(num[i]);
		
		System.out.println("\nReverse Order:");
		for(int i=num.length-1;i>=0;i--)
			System.out.println(num[i]);
		
		System.out.println("\nFirst and Last elements:");
		System.out.println(num[0] + "\n" + num[num.length-1]);
	}
}
