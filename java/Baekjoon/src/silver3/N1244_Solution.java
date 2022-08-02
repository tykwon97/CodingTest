package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N1244_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(in.readLine());

		String[] arr = in.readLine().split(" ");
		int[] switchArr = new int[switchNum];

		for(int i=0; i<switchNum; i++) {
			switchArr[i] = Integer.parseInt(arr[i]);
		}

		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			String[] person = in.readLine().split(" ");
			if(person[0].equals("1")) {
				int multiple = Integer.parseInt(person[1]);
				int index = multiple-1;
				while(index < switchNum) {
					if(switchArr[index] == 0)
						switchArr[index]++;
					else
						switchArr[index]--;
					index += multiple;
				}

			}else {
				int j = 0;
				int pivot = Integer.parseInt(person[1])-1;

				if(switchArr[pivot] == 0)
					switchArr[pivot]++;
				else
					switchArr[pivot]--;
				
				while(true) {
					if(pivot-1-j >= 0 && pivot+1+j < switchNum) {
						if(switchArr[pivot-1-j] == switchArr[pivot+1+j]) {
							if(switchArr[pivot-1-j] == 0) {
								switchArr[pivot-1-j]++;
								switchArr[pivot+1+j]++;
							}else {
								switchArr[pivot-1-j]--;
								switchArr[pivot+1+j]--;
							}
						}else 
							break;
						j += 1;

					}else 
						break;
				}
			}
		}

		for(int i=0; i<switchNum; i++) {
			if((i+1)%20 == 0) {
				System.out.println(switchArr[i]);
			}else {
				System.out.print(switchArr[i]+" ");
			}
		}
	}
}
