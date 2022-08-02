package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class N1208_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	 
	        for(int test_case = 1; test_case <= 10; test_case++)
	        {
	        	int n = Integer.parseInt(in.readLine());
	            String[] a = in.readLine().split(" ");
//	            System.out.println(Arrays.toString(a));
	            int[] arr = new int[100];
	            
	            for(int i=0; i<100; i++) {
	            	arr[i] = Integer.parseInt(a[i]);
	            }
	            
	            Arrays.sort(arr);
	            for(int i=0; i<n; i++) {
	            	if(arr[0] == arr[99])
	            		break;
	            	arr[0]++;
	            	arr[99]--;
	            	Arrays.sort(arr);
	            }
	            int diff = arr[99]-arr[0];
	            System.out.println("#"+test_case+" "+diff);
	        }
	}
}
