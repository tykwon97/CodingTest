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

public class N10814_Solution {
	public static class Person{
		int age;
		String name;
		Person(int age, String name){  
			this.age = age;
			this.name = name;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(in.readLine());

		List<Person> list = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			Person p = new Person(age,name);
			list.add(p);
		}
		
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.age - o2.age;
			}
		});
		
		for(Person p : list) {
			sb.append(p.age).append(" ").append(p.name).append("\n");
		}

		System.out.println(sb);
	}
}
