package Day0801;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class N1289_RecoveryWonjaeMemory {
	public static void main(String args[]) throws Exception
	{

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int count = 0;
			
			char[] arr = in.readLine().toCharArray();
			int len = arr.length;
			for(int i=0; i<len; i++) {
				if(arr[i]== '1') {
					for(int j=i; j<len; j++) {
						if(arr[j] == '0')
							arr[j]++;
						else
							arr[j]--;
					}
					count ++;
				}
			}

			System.out.println("#"+test_case+" "+count);
		}
	}
}
