package silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class N7568_Solution {
	
	/*
	 * 몸무게와 키 순으로 Comparator를 이용해 정렬 후 문제를 풀 생각이었지만
	 * 정렬 기준이 정확하게 구현할 수 없었고 단순히 본인 보다 덩치가 큰 사람의 수를 더하는 문제였다.
	 * 순위가 아닌 점수제에 가깝다고 생각한다.
	 */
	
	public static class Person {
		int kg;
		int height;
		
		Person(int kg, int height, int index){
			this.kg = kg;
			this.height = height;
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(in.readLine());
		
		Person[] list = new Person[num];
		
		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int kg = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			list[i] = new Person(kg,height,i);
			
		}
		
		int result[] = new int[num];
		for (int i = 0; i < num; i++) {
			result[i] = 1;
		}
		
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				if(list[i].kg < list[j].kg && list[i].height < list[j].height) {
					result[i]++;
				}
			}
		}
		
		
		for(int x : result) {
			sb.append(x).append(" ");
		}
		
		System.out.println(sb);
	}
}
