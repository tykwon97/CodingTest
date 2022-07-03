import java.util.Scanner;

public class N1152_CountWord {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int[] arr = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		int index = 0;
		for(int i=0;i<10;i++) {
			int result = input.nextInt()%42;
			boolean flag = true;
			for(int j=0;j<index;j++) {
				if(arr[j] == result) {
					flag = false;
				}
			}
			if(flag) {
				arr[index] = result;
				index += 1;
			}
		}
		
		System.out.println(index);
		
		

	}

}
