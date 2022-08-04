import java.util.Scanner;

public class N1439_Reverse {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		String str = input.next();
		
		int count0 = 0;
		int count1 = 0;
		char temp = ' ';
		for(int i=0; i<str.length(); i++) {
			char x = str.charAt(i);
			if(x == '1') {
				if(temp != x)
					count1 += 1;
			}else{
				if(temp != x)
					count0 += 1;
			}
			temp = x;
		}
		
		System.out.println(count0>count1?count1:count0);
	}

}
