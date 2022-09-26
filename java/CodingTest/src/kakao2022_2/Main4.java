package kakao2022_2;

import java.util.Arrays;
import java.util.Stack;

public class Main4 {
	public static void main(String[] args) {
		long nubmers[] = {95};
		solution(nubmers);
	}
	public static int[] arr;
	public static int[] solution(long[] numbers) {
		
        int[] answer = new int[numbers.length];
		
		
		for (int i = 0; i < numbers.length; i++) {
			Stack<Integer> stack = new Stack<>();
			long x = numbers[i];
			int size = 0;
			while(x!=0) {
				size++;
				stack.push((int) (x%2));
				x/=2;
			}
			int total = 1;
			int k=1;
			while(size > total) {
				k *=2;
				total+=k;
			}
			arr = new int[total];
			int index = total-size;
//			System.out.println("index :" +index);
			while(!stack.isEmpty()) {
				arr[index++] = (stack.pop());
			}
			System.out.println(Arrays.toString(arr));
			
			answer[i] = (binarySearch(true, 0, total-1));
		} 
		
//		System.out.println(Arrays.toString(arr));
//		System.out.println(answer[0]);
        return answer;
    }
	
	public static int binarySearch(boolean flag, int low, int high) {
		int mid;
		if(low <= high) {
			mid = (low + high) / 2;
//			System.out.println("mid : "+mid);
			if(flag == true) {
				if(1==arr[mid]) {
					int x = binarySearch(true ,low, mid-1);  
					int y =binarySearch(true, mid+1, high); 
//					System.out.println("x: "+x+" y := "+y);
					if(x==0 || y==0) {
						return 0;
					}else {
						return 1;
					}
				}else {
					int x = binarySearch(false ,low, mid-1);  
					int y =binarySearch(false, mid+1, high); 
					if(x==0 || y==0) {
						return 0;
					}else {
						return 1;
					}
					
				}
			}else {
				if(1==arr[mid]) {
//					System.out.println("끝");
					return 0;
				}else {
					int x = binarySearch(false ,low, mid-1);  
					int y =binarySearch(false, mid+1, high); 
					if(x==0 || y==0) {
						return 0;
					}else {
						return 1;
					}
				}
			}
		}
		return 1;
	}
	
}
