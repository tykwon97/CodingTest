import java.util.Scanner;

public class N8958_OXquiz {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		
		for(int j=0;j<n;j++) {
			String user_input = input.next();
			
			int count = 1;
			int result = 0;
			
			for(int i=0;i<user_input.length();i++) {
				char x = user_input.charAt(i);
				
//				System.out.println(x);	
				if(x == 'O') {
					result += count;
					count += 1;
				}else {
					count = 1;
				}
			}
			System.out.println(result);	
		}
		
		
	}

}
