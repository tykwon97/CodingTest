package Gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5972_택배배송 {
	
	class Barn { // Barn : 헛간 
		int feed;
		Barn next;
		
		Barn(int feed, Barn next){
			this.feed = feed;
			this.next = next;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Barn[] barns = new Barn[n+1];
		
		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int feed = Integer.parseInt(st.nextToken());
			
			
			barns[from] = new Barn(feed, barns[from]);
			
		}

		System.out.println(sb);
	}

}
