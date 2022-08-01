package silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N1244_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int switchNum = Integer.parseInt(in.readLine());

		char[] switchArr = in.readLine().toCharArray();

		int n = Integer.parseInt(in.readLine());
		for(int i=0; i<n; i++) {
			char[] person = in.readLine().toCharArray();
			if(person[0] == '1') {
				int multiple = person[2]-'0';
				int index = multiple-1;
				while(index < switchNum) {
					if(switchArr[index*2] == '0')
						switchArr[index*2]++;
					else
						switchArr[index*2]--;
					index += multiple;
				}


			}else {
				int j = 0;
				int pivot = person[2]-'0';
				while(true) {
					if(pivot-1-j >= 0 && pivot+1+j < switchNum) {
						if(switchArr[(pivot-1-j)*2] == switchArr[(pivot+1+j)*2]) {
							if(switchArr[(pivot-1-j)*2] == '0')
								switchArr[(pivot-1-j)*2]++;
							else
								switchArr[(pivot-1-j)*2]--;
							
							if(switchArr[(pivot+1+j)*2] == '0')
								switchArr[(pivot+1+j)*2]++;
							else
								switchArr[(pivot+1+j)*2]--;
						}else {
							if(j == 0) {
								if(switchArr[pivot*2] == '0')
									switchArr[pivot*2]++;
								else
									switchArr[pivot*2]--;
								break;
							}else {
								break;
							}
							
							
						}
						j += 1;
							
						
					}else {
						if(switchArr[pivot*2] == '0')
							switchArr[pivot*2]++;
						else
							switchArr[pivot*2]--;
					}

				}
			}
			System.out.println(switchArr);
		}
	}
}
