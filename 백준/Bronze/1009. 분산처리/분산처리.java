import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		list = new List[10];
		for (int i = 0; i < 10; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		distributedProcessing();
		
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken())%10;
			int b = Integer.parseInt(st.nextToken());
			
			int size = list[a].size();
			int index = (b-1)%size;
			
			int result = list[a].get(index);
			sb.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
	private static void distributedProcessing() {
		list[0].add(10);
		
		for (int i = 1; i < 10; i++) {
			list[i].add(i);
			int num = i*i%10;
			while(num != i) {
				list[i].add(num);
				num = num*i%10;
			}
		}
	}
}