//  Name: Tyler Davis
//  Class: CSE 271
//  Problem:  P6.4
import java.util.Random;

public class P6_4 {
	public static void main(String args[]) {
		
		int[] num = new int[9];
		Random number = new Random();
		for(int i=0;i<num.length;i++)
			num[i] = number.nextInt(50);
		
		int sum=sumWithoutSmallest(num);
		System.out.println("Sum without smallest value: "+(sum));
	}
	public static int sumWithoutSmallest(int[] nums) {
		
		int small=Integer.MAX_VALUE,sum=0;
		for(int i=0;i<nums.length;i++){
			if(nums[i]<small)
				small=nums[i];
			sum+=nums[i];
			
		}
		return sum-small;
	}
}
