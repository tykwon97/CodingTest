package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10950_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[26];

		String str = in.readLine();
		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if(x>=97) {
				arr[x-97]++;
			}else {
				arr[x-65]++;
			}
		}
		boolean flag = false;
		int maxCount = 0;
		char maxValue = 'A';
		System.out.println(Arrays.toString(arr));
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > maxCount) {
				maxCount = arr[i];
				maxValue = (char)(i+65);
				flag = true;
			}else if(arr[i]!= 0 && arr[i] == maxCount) {

				maxCount++;
				flag = false;
			}
		}
		if(flag) {
			System.out.println(maxValue);
		}else {
			System.out.println("?");
		}
	}

}
