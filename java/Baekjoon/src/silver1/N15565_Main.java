package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N15565_Main {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int result = N+1;
		
		int cnt = 0; 
		int temp = 0; // k개까지의 총합
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
//			System.out.println(" i : "+i + " K : "+K);
			if(x==1) {
				cnt++;
				
				queue.add(cnt);
				
				temp += cnt;

				if(K<=0) {
					temp -= queue.poll();
//					System.out.println("temp : "+temp);
					
					if(result > temp)
						result = temp;
					
				}else {
					K--;
				}
				cnt = 0;				
				
			}else {
				cnt++;				
			}
					System.out.println("K : "+K);
		}
		
		System.out.println((K<=1)?result+1:"-1");
	}
}




