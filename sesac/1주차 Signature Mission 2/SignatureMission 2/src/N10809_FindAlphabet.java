import java.util.Scanner;

public class N10809_FindAlphabet {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String s = input.next();
		
		int[] arr = new int[26];
		
		for(int i=0; i<26; i++) {
			arr[i] = -1;
		}
		
		for(int i=0; i<s.length(); i++) {
			char x = s.charAt(i);  
			int index = x-'a';
			if(arr[index] == -1) {
				arr[index] = i;	
			}
			
		}
		
		System.out.print(arr[0]);
		for(int i=1; i<26; i++) {
			System.out.print(" "+arr[i]);
		}
		
	}

}
