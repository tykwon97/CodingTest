package d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class N1218_Solution {

	public static LinkedList[] list;
	public static boolean[] isSelected;
	public static int[] counts;
	public static int maxCount;
	public static int maxValue;
	public static HashMap<Integer, Integer> map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for(int tc=1; tc<=10; tc++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			maxCount = 0;
			maxValue = Integer.MIN_VALUE;

			list = new LinkedList[n];
			isSelected = new boolean[n];
			counts = new int[n];
			
			map = new HashMap<>();

			for (int i = 0; i < list.length; i++) {
				list[i] = new LinkedList<Integer>();
			}
			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < n/2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				list[from].add(to);
			}


			counts[start] = 1;
			contactNetwork(start,1);
			
			for (int i = 1; i < counts.length; i++) {
				if(counts[i]>maxCount) {
					maxCount = counts[i];
					maxValue = i;
				}else if(counts[i] == maxCount) {
					if(maxValue < i)
						maxValue = i;
				}
			}


			sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
		}

		System.out.println(sb);
	}

	private static void contactNetwork(int start, int cnt) {

		isSelected[start] = true;
		
		int size = list[start].size();

		if(size == 0)
			return;
		
		for (int i = size-1; i >= 0; i--) {
			int newStart = (int) list[start].get(i);
			if(!isSelected[newStart] || (counts[newStart] > cnt+1 && isSelected[newStart])) {
				counts[newStart] = cnt+1;
				contactNetwork(newStart,cnt+1);
			}
		}

	}
}
