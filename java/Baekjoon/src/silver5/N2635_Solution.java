package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N2635_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] input = in.readLine().toCharArray();
		String result = "";
		for (char x : input) {
			if(x>=97) {
				x = (char) (x-32);
			}else {
				x = (char)(x+32);
			}
			result += x;
		}
		System.out.println(result);
	}
}
