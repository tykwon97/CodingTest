package bronze3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N4153_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String[] arr = in.readLine().split(" ");
			int temp1 = Integer.parseInt(arr[0]);
			int temp2 = Integer.parseInt(arr[1]);
			int temp3 = Integer.parseInt(arr[2]);
			if(temp1==0 && temp1==temp2 && temp2==temp3) {
				break;
			}
			
			if(temp1 > temp3) {
				int temp = temp3;
				temp3 = temp1;
				temp1 = temp;
			}
			
			if(temp2 > temp3) {
				int temp = temp3;
				temp3 = temp2;
				temp2 = temp;
			}
			
			if(temp3*temp3 == temp1*temp1 + temp2*temp2) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
			
			
		}

	}

}
