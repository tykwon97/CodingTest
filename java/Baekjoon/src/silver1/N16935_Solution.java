package silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class N16935_Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];
		int[][] temp = null;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		String count = null;
		st = new StringTokenizer(in.readLine()," ");
		for(int i=0; i<r; i++){
			count = st.nextToken();
			
			switch (count) {
			case "1":
					Queue<int[]> list = new LinkedList<>();
					for (int j = 0; j < n; j++) {
						list.add(arr[j]);
					}
					for (int j  = n-1; j >= 0; j--) {
						arr[j] = list.poll();
					}
				break;
			case "2":
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < m/2; k++) {
							int tempValue = arr[j][k];
							arr[j][k] = arr[j][m-k-1];
							arr[j][m-k-1] = tempValue;
						}
					}
				break;
			case "3":
					temp = new int[m][n];
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < m; k++) {
							temp[k][n-j-1] = arr[j][k]; 
						}	
					}

					arr = new int[m][n];
					arr = temp;
					int tempValue = m;
					m = n;
					n = tempValue;
				break;
			case "4":
					temp = new int[m][n];
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < m; k++) {
							temp[m-k-1][j] = arr[j][k]; 
						}	
					}

					arr = new int[m][n];
					arr = temp;
					tempValue = m;
					m = n;
					n = tempValue;
				break;
			case "5":
					temp = new int[n/2][m/2];
					for (int j = 0; j < n/2; j++) {
						for (int k = 0; k < m/2; k++) {
							temp[j][k] = arr[j][k];
						}
					}
					int[] dx = {0,n/2,0,-n/2};
					int[] dy = {m/2,0,-m/2,0};
					int x = 0;
					int y = 0;
					for (int z = 0; z < 4; z++) {
						x = x+dx[z];
						y = y+dy[z];
						for (int j = 0; j < n/2; j++) {
							for (int k = 0; k < m/2; k++) {
								int value = temp[j][k];
								temp[j][k] = arr[x+j][y+k];
								arr[x+j][y+k] = value;
							}
						}
					}
				break;
			case "6":
					temp = new int[n/2][m/2];
					for (int j = 0; j < n/2; j++) {
						for (int k = 0; k < m/2; k++) {
							temp[j][k] = arr[j][k];
						}
					}
					int[] dx1 = {n/2,0,-n/2,0};
					int[] dy1 = {0,m/2,0,-m/2};
					int x1 = 0;
					int y1 = 0;
					for (int z = 0; z < 4; z++) {
						x1 = x1+dx1[z];
						y1 = y1+dy1[z];
						for (int j = 0; j < n/2; j++) {
							for (int k = 0; k < m/2; k++) {
								int value = temp[j][k];
								temp[j][k] = arr[x1+j][y1+k];
								arr[x1+j][y1+k] = value;
							}
						}
					}

				break;
			default:
				break;
			}
		}

		switch (count) {
		case "1":
		case "2":
		case "5":
		case "6":
			for(int[] map : arr) {
				for(int x : map) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
			break;
		case "3":
		case "4":
			for(int[] map : temp) {
				for(int x : map) {
					System.out.print(x+" ");
				}
				System.out.println();
			}
			break;
		}


	}
}
