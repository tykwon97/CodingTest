package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1085_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] arr = in.readLine().split(" ");
			int x = Integer.parseInt(arr[0]);
			int y = Integer.parseInt(arr[1]);
			int w = Integer.parseInt(arr[2]);
			int h = Integer.parseInt(arr[3]);
			
			int xy, min_xy;
			if(x>y) {
				xy = y;
			}else {
				xy = x;
			}
			
			int min_x = w-x;
			int min_y = h-y;
			
			if(min_x > min_y) {
				min_xy = min_y;
			}else {
				min_xy = min_x;
			}
			
			if(xy > min_xy) {
				System.out.println(min_xy);
			}else {
				System.out.println(xy);
			}
		
			

		}

	}
}