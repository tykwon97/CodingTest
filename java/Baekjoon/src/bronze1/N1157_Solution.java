package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1157_Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println('a'+0);
		System.out.println('z'+0);
		System.out.println('Z'+0);
		int[] arr = new int[26];
		
		String str = in.readLine();
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x>97) {
				arr[x-97]++;
			}else {
				arr[x-65]++;
			}
		}
		
		int maxCount = 0;
		char maxValue = 'A';
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > maxCount) {
				maxCount = 1;
				maxValue = (char)(i+97);
			}else if(arr[i] == maxCount)
				maxCount++;
		}
		if(maxCount != 1) {
			System.out.println("?");
		}else {
			System.out.println(maxValue);
		}
	}

}
