package exercise;
/*
You should use the statndard input/output
in order to receive a score properly.
Do not use file input and output
Please be very careful. 
 */

/*
 초등학교교 학생인 정우와 석환이는 최근 학교에서 두 이진수의 XOR 연산에 대해 배웠다.
 둘은 매우 영특한 학생이라 새로 배운 연산을 갖고 이리저리 장난치기 시작했다.
 다만 석환이는 정우에게 일을 시키는 것을 좋아하는지라 다음과 같은 제안을 했다.

“내가 N개의 10진수를 주면, 등장하는 숫자들 중 홀수번만 나타나는 숫자들을 모두 XOR한 결과를 구해줘.”

예를 들어 '2, 5, 3, 3' 이 주어질 경우, '2'와'5'는 1번(홀수 번) 나타나고 '3' 은 2번 (짝수 번) 나타나므로
홀수 번 나타난 '2' 와 '5'를 XOR 한 결과를 구해야 하고,
'2, 5, 3, 3, 2, 4, 5, 3' 이 주어질 경우 '2' 와 '5' 는 2번 나타나고, '3' 은 3번, '4' 는 1번 나타나므로
홀수 번 나타난 '3' 과 '4'를 XOR 한 결과를 구해야 한다.

정우는 제안을 수락했지만, 가면 갈수록 매번 XOR 연산을 수행하는 일에 지치고 있다.
정우를 도와서 주어 진 문제를 해결하는 프로그램을 작성하라.

- 제한시간: 전체 테스트 케이스는 20개 이하이며, 전체 수행 시간은 1초 이내. (Java 2초 이내) 
    제한 시간을 초과하면 제출한 소스코드의 프로그램이 즉시 종료되며,
    그때까지 수행한 결과에서 테스트 케이스를 1개 그룹 이상 통과하였더라도 점수는 0점이 됩니다.
    그러나, 제한 시간을 초과하더라도 테스트 케이스를 1개 그룹 이상 통과하였다면 '부분 점수(0< 점수< 만점)'를 받을 수 있으며,
    이를 위해서는, C / C++ 에서 "printf 함수" 사용할 경우, 프로그램 시작부분에서 "setbuf(stdout, NULL);"를 한번만 사용하십시오.
    C++에서는 "setbuf(stdout, NULL);"와 "printf 함수" 대신 "cout"를 사용하고, Java에서는 "System.out.printIn"을 사용하시면,
    제한 시간을 초과하더라도 '부분 점수'를 받을 수 있습니다.                                     ※ 언어별 기본 제공 소스코드 내용 참고
    만약, 제한 시간을 초과하지 않았는데도 '부분 점수'를 받았다면, 일부 테스트 케이스를 통과하지 못한 경우 입니다.

- 메모리 사용 제한 : heap, global, static 총계 256MB, stack 1MB 
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
			//수정하는 부분

			int num = sc.nextInt();
			int[] arr = new int[num];
			int[] arr_num = new int[3000000];

			for(int i=0; i<num;i++) {
				arr[i]=sc.nextInt();
				arr_num[arr[i]]++;
			}

			// XOR연산 -> ^
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

