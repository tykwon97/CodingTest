package bronze1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
<<<<<<< HEAD
=======
import java.util.StringTokenizer;

>>>>>>> 8a95528a284c4a8bd84083818f2da534425428c6
public class N1110_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(in.readLine());
		int count = 0;
		int x = num;
		do {
<<<<<<< HEAD
			
=======
			if(x<10) {
				x *= 10;
			}
>>>>>>> 8a95528a284c4a8bd84083818f2da534425428c6
			int a = x/10%10;
			int b = x%10;
			x = b*10+(a+b)%10;
			count+=1;
//			System.out.println("a : "+a+ " b : "+b+" x : "+x+" count : "+count);
			
		}while(x != num);
		System.out.println(count);
	}

}
