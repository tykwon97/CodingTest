import java.util.Arrays;
import java.util.Scanner;

public class N1316_GroupWordChecker {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int num = input.nextInt();
		
		int[] arr = new int[26];
		
		int count = 0;
		
		for(int i=0; i<num; i++) {
			Arrays.fill(arr, 0);
			String str = input.next();
			char temp = ' ';
			boolean flag = true;
			for(int j=0; j<str.length(); j++) {
				char x = str.charAt(j);
				if(arr[x-'a'] == 0) {
					arr[x-'a'] = 1;
				}else {
					if(temp !=x) {
						flag = false;
						break;
					}
					
				}
				temp = x;
			}
			if(flag)
				count += 1;
		}
		System.out.println(count);
	}

}
