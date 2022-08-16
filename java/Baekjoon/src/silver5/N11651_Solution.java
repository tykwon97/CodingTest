package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class N11651_Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());
		Coordinate[] coordinates = new Coordinate[num];
		
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			coordinates[i] = new Coordinate(x, y);
			
		}
		
		Arrays.sort(coordinates, new Comparator<Coordinate>() {

			@Override
			public int compare(Coordinate o1, Coordinate o2) {
				if(o1.y == o2.y) {
					return o1.x - o2.x;
				}
				return o1.y - o2.y;
			}
		});
		
		for(Coordinate c : coordinates) {
			sb.append(c.x).append(" ").append(c.y).append("\n");
		}

		System.out.println(sb);
	}
	
	public static class Coordinate {
		int x;
		int y;
		
		Coordinate(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}


