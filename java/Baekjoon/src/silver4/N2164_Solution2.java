package silver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class N2164_Solution2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		int num = Integer.parseInt(in.readLine());
		
		int x = 2;
		while(num>x) {
			x *= 2;
		}
		
		x /= 2;
		
		if(num == 1) {
			System.out.println("1");
		}else {
			System.out.println((num-x)*2);
		}
	}
}
