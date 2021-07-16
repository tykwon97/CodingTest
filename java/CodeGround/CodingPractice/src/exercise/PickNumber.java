package exercise;
/*
You should use the statndard input/output
in order to receive a score properly.
Do not use file input and output
Please be very careful. 
 */

/*
 �ʵ��б��� �л��� ����� ��ȯ�̴� �ֱ� �б����� �� �������� XOR ���꿡 ���� �����.
 ���� �ſ� ��Ư�� �л��̶� ���� ��� ������ ���� �̸����� �峭ġ�� �����ߴ�.
 �ٸ� ��ȯ�̴� ���쿡�� ���� ��Ű�� ���� �����ϴ����� ������ ���� ������ �ߴ�.

������ N���� 10������ �ָ�, �����ϴ� ���ڵ� �� Ȧ������ ��Ÿ���� ���ڵ��� ��� XOR�� ����� ������.��

���� ��� '2, 5, 3, 3' �� �־��� ���, '2'��'5'�� 1��(Ȧ�� ��) ��Ÿ���� '3' �� 2�� (¦�� ��) ��Ÿ���Ƿ�
Ȧ�� �� ��Ÿ�� '2' �� '5'�� XOR �� ����� ���ؾ� �ϰ�,
'2, 5, 3, 3, 2, 4, 5, 3' �� �־��� ��� '2' �� '5' �� 2�� ��Ÿ����, '3' �� 3��, '4' �� 1�� ��Ÿ���Ƿ�
Ȧ�� �� ��Ÿ�� '3' �� '4'�� XOR �� ����� ���ؾ� �Ѵ�.

����� ������ ����������, ���� ������ �Ź� XOR ������ �����ϴ� �Ͽ� ��ġ�� �ִ�.
���츦 ���ͼ� �־� �� ������ �ذ��ϴ� ���α׷��� �ۼ��϶�.

- ���ѽð�: ��ü �׽�Ʈ ���̽��� 20�� �����̸�, ��ü ���� �ð��� 1�� �̳�. (Java 2�� �̳�) 
    ���� �ð��� �ʰ��ϸ� ������ �ҽ��ڵ��� ���α׷��� ��� ����Ǹ�,
    �׶����� ������ ������� �׽�Ʈ ���̽��� 1�� �׷� �̻� ����Ͽ����� ������ 0���� �˴ϴ�.
    �׷���, ���� �ð��� �ʰ��ϴ��� �׽�Ʈ ���̽��� 1�� �׷� �̻� ����Ͽ��ٸ� '�κ� ����(0< ����< ����)'�� ���� �� ������,
    �̸� ���ؼ���, C / C++ ���� "printf �Լ�" ����� ���, ���α׷� ���ۺκп��� "setbuf(stdout, NULL);"�� �ѹ��� ����Ͻʽÿ�.
    C++������ "setbuf(stdout, NULL);"�� "printf �Լ�" ��� "cout"�� ����ϰ�, Java������ "System.out.printIn"�� ����Ͻø�,
    ���� �ð��� �ʰ��ϴ��� '�κ� ����'�� ���� �� �ֽ��ϴ�.                                     �� �� �⺻ ���� �ҽ��ڵ� ���� ����
    ����, ���� �ð��� �ʰ����� �ʾҴµ��� '�κ� ����'�� �޾Ҵٸ�, �Ϻ� �׽�Ʈ ���̽��� ������� ���� ��� �Դϴ�.

- �޸� ��� ���� : heap, global, static �Ѱ� 256MB, stack 1MB 
 */

import java.util.Scanner;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */

public class PickNumber {
	static int Answer;
	public static void main(String[] args) {
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).

		   Make new scanner from standard input System.in, and read data.
		 */
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt();
		for(int test_case = 0; test_case < T; test_case++) {

			Answer = 0;
			/////////////////////////////////////////////////////////////////////////////////////////////
			//�����ϴ� �κ�

			int num = sc.nextInt();
			int[] arr = new int[num];
			int[] arr_num = new int[3000000];

			for(int i=0; i<num;i++) {
				arr[i]=sc.nextInt();
				arr_num[arr[i]]++;
			}

			// XOR���� -> ^
			for(int i=0; i<3000000;i++) {
				if(arr_num[i]!=0) {
					if(arr_num[i]%2 == 1) {
						if(Answer == 0) {
							Answer = i;
						}else {
							Answer = Answer ^ i;
						}
					}
				}
			}

			//			for(int i = 0; i < arr.length; i++) { 
			//			System.out.println(arr[i]); 
			//		}

			/////////////////////////////////////////////////////////////////////////////////////////////

			// Print the answer to standard output(screen).
			System.out.println("Case #"+(test_case+1));
			System.out.println(Answer);



		}
	}
}

