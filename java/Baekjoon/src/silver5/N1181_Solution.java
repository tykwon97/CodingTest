package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N1181_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());
		
		List<String> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			list.add(in.readLine());
		}
		
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int len1 = o1.length();
				int len2 = o2.length();
				
				if(len1 == len2)
					return o1.compareTo(o2);
				else
					return len1 - len2;
			}
		});
		
		String prevStr = "";
		for(String x : list) {
			if(!x.equals(prevStr)) {
				sb.append(x).append("\n");
				prevStr = x;
			}
		}
		System.out.println(sb);
	}
}
