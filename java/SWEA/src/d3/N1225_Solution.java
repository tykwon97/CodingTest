package d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class N1225_Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for(int test_case = 1; test_case <= 10; test_case++){
			Queue<Integer> queue = new ArrayDeque<Integer>();
			in.readLine();
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0; i< 8; i++) {
				queue.add(Integer.parseInt(st.nextToken()));
			}
			boolean flag = true;
			while(flag) {
				for (int j = 1; j <= 5; j++) {
					int x = queue.poll()-j;
					if(x>0) {
						queue.add(x);
					}else {
						queue.add(0);
						flag = false;
						break;
					}
				}

			}
			sb.append("#");
			sb.append(test_case);
			sb.append(" ");

			while(queue.size() > 0) {
				sb.append(queue.poll()).append(" ");
			}
			sb.append("\n");

		}
		System.out.println(sb);
	}
}
