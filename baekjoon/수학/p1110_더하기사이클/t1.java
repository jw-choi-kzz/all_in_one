package 수학_p1110_더하기사이클;

import java.util.Scanner;

/*
 * 10보다 작으면 앞에 0을 붙인다
 * 각 자리의 숫자를 더한다 = 합
 * 주어진 수의 가장 오른쪽 자리 수와 앞의 가장 오른쪽 자리 수를 붙여  
 * 사이클 : 원래 수로 돌아오는 횟수
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int save = n; //처음 수 저장은 n에 하고, save에 변형을 줄 예정
		int now = -1; //절대 안나올 숫자 하나 임의로
		int cnt = 0; //사이클 cnt
		while (now != n) {
			//지금 숫자가 무엇인지 저장하고
			now = save;
			//합구하고 새로운 숫자 만드는 과정			
			cnt++;
			int sum = now/10 + now%10; //두 자리수의 각 자리 수 합
			now = sum%10 + save%10*10; //새로운 숫자 만들어짐
			if (now == n) {
				System.out.println(cnt);
				break;
			} else {
				save = now;				
			}
		} //n이 나올때까지 반복
	} //main
} //class
