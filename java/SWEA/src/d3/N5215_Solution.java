package d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N5215_Solution {
	public static int n;
	public static int l;
	public static int[] list;
	public static int max;
	
    public static void main(String args[]) throws Exception{
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(in.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
        	st = new StringTokenizer(in.readLine()," ");
        	n = Integer.parseInt(st.nextToken());
        	l = Integer.parseInt(st.nextToken());
        	
        	list = new int[n*2]; 
        	for (int i = 0; i < n; i++) {
        		st = new StringTokenizer(in.readLine()," ");
            	int score = Integer.parseInt(st.nextToken());
            	list[i*2] = score;
            	int kcal = Integer.parseInt(st.nextToken());
            	list[i*2+1] = kcal;
			}
        	max = 0;
        	comb(0,0,0);
            sb.append("#").append(test_case).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

	private static void comb(int score, int kcal,int index) {

		if(kcal<=l) {
			if(max<score) {
				max = score;
			}
		}else {
			return;
		}
		if(index >= n*2) {
			return;
		}
		
		comb(score + list[index], kcal+list[index+1], index+2);
		comb(score,kcal,index+2);
		
	}
}