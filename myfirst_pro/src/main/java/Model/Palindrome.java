package Model;

public class Palindrome {
	public static int isPalindrome(int num)
	{
		int rem;
		int rev_num=0;
		
		while(num !=0)
		{
			rem = num%10;
			rev_num = rev_num*10+rem;
			num /=10;
		}
		return rev_num;
	}
}
