import java.util.Scanner;

public class N2941_CroatiaAlphabet {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		String str = input.next();
		int count = 0;
		for(int i=0; i<str.length(); i++) {
			char x = str.charAt(i);
			if(x == 'c' && i <= str.length()-2) {
				x = str.charAt(i+1);
				if(x == '=') {
					count += 1;
					i += 1;
				}
				else if(x == '-') {
					count += 1;
					i += 1;
				}
				else {
					count += 1;
				}
			}else if(x == 'd' && i <= str.length()-2) {
				x = str.charAt(i+1);
//				System.out.println("x : "+x+" i : "+i+" count : "+count);
				if(x == 'z' && i <= str.length()-3) {
					x = str.charAt(i+2);
					if(x == '=') {
						count += 1;
						i += 2;
					}else
						count += 1;
				}
				else if(x == '-') {
					count += 1;
					i += 1;
				}else {
					count += 1;
				}

//				System.out.println("x : "+x+" i : "+i+" count : "+count+"\n");

			}else if(x == 'l' && i <= str.length()-2) {
				x = str.charAt(i+1);
				if(x == 'j') {
					count += 1;
					i += 1;
				}
				else {
					count += 1;
				}
			}else if(x == 'n' && i <= str.length()-2) {
				x = str.charAt(i+1);
				if(x == 'j') {
					count += 1;
					i += 1;
				}
				else {
					count += 1;
				}
			}else if(x == 's' && i <= str.length()-2) {
				x = str.charAt(i+1);
				if(x == '=') {
					count += 1;
					i += 1;
				}
				else {
					count += 1;
				}
			}else if(x == 'z' && i <= str.length()-2) {
				x = str.charAt(i+1);
				if(x == '=') {
					count += 1;
					i += 1;
				}
				else {
					count += 1;
				}
			}else {
				count += 1;
			}
		}
		System.out.println(count);
	}

}
