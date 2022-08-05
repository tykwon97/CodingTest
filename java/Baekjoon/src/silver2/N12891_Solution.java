package silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N12891_Solution {

	private static int cnt;
	static int reala=0,realc=0,realg=0,realt=0;
	static int numA,numC,numG,numT;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char[] arr = in.readLine().toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 'A')
				reala++;
			else if(arr[i] == 'C'){
				realc++;
			}else if(arr[i] == 'G'){
				realg++;
			}else if(arr[i] == 'T'){
				realt++;			
			}
		}
		
		st = new StringTokenizer(in.readLine(), " ");
		numA = Integer.parseInt(st.nextToken());
		numC = Integer.parseInt(st.nextToken());
		numG = Integer.parseInt(st.nextToken());
		numT = Integer.parseInt(st.nextToken());

		pwd(arr,m,0,n,"");
		
		System.out.println(cnt);
	}

	private static void pwd(char[] arr, int m, int cnt,int total,String str) {
		if(cnt > total)
			return;
		if(cnt == m) {
			int a=0,c=0,g=0,t=0;
			for (int i = 0; i < m; i++) {
				if(arr[i] == 'A')
					a++;
				else if(arr[i] == 'C'){
					c++;
				}else if(arr[i] == 'G'){
					g++;
				}else if(arr[i] == 'T'){
					t++;			
				}
			}
			if(numA<=a && a<=reala && numC<=c && c<=realc && numG<=g && g<=realg && numT<=t && a<=realt )
				cnt++;
			return;
		}
		pwd(arr,m,cnt+1,total,str+arr[cnt]);
		pwd(arr,m,cnt+1,total,str);
		
	}
	
	

	
}
