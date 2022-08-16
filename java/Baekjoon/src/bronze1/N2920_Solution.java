package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2920_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");

		int n = Integer.parseInt(st.nextToken());

		int flag = -1;
		int value = -1;

		if(n == 1) {
			flag = 1;
			value = 2;
		}else if(n == 8){
			flag = 2;
			value = 7;
		}else {
			flag = 3;
		}

		while(st.countTokens()!=0) {
			n = Integer.parseInt(st.nextToken());
			if(flag == 1) {
				if(n==value) {
					value++;
				}else {
					flag = 3;
				}
			}else if(flag == 2) {
				if(n==value) {
					value--;
				}else {
					flag = 3;
				}
			}else {
				continue;
			}
		}
		if(flag == 1) {
			System.out.println("ascending");
		}else if(flag == 2) {
			System.out.println("descending");
		}else {
			System.out.println("mixed");;
		}
	}
}