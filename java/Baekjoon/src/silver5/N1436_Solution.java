package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N1436_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String movieName="666";
		int num = Integer.parseInt(in.readLine());
		
		int count = 666;
		String str = "";
		while(num != 0) {
			str = count+"";
			if(str.contains("666")) {
				num--;
			}
			count++;
		}
		System.out.println(str);
		
	}
}
