package bronze2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N11949_Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(in.readLine());
		}
		
		for (int i = 1; i <= m; i++) {
			for (int j = 0; j < n-1; j++) {
				if(arr[j]%i > arr[j+1]%i) { 
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}else {
					continue;
				}
			}
		}
		for(int x : arr){
			System.out.println(x);
		}
		
		
	}

}