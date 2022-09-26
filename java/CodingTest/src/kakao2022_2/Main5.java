package kakao2022_2;

public class Main5 {
	public static void main(String[] args) {
		String[] commands = {""};
		solution(commands);
	}

	public static int[] parent = new int[10];
	public static String[] solution(String[] commands) {
		String[] answer = {};
		return answer;
	}
	
	public static void makeset(int x){
		parent[x] = x;
	}
	public static int findset(int x) {
		if(x==parent[x])
			return x;
		else {
			parent[x] = findset(parent[x]);
			return parent[x];
		}
	}
	public static void union(int x, int y) {
		int px = findset(x);
		int py = findset(y);
		if(px!= py) {
			parent[py] = px;
		}
	}
}
