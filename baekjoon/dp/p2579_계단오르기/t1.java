package dp_p2579_계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 각 계단에 점수가 주어지면 총 점수의 최댓값
 * 계단 1 or 2개씩. 연속된 3개의 계단 밟기 x(1/1/1 x). 마지막 계단은 밟아야.
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //계단의 개수
		int[] score = new int [n+1];
		for (int i = 1; i <= n; i++) {
			score[i] = Integer.parseInt(br.readLine()); //해당 계단 점수
		}
		int[] dp = new int[n+1];
		
		dp[1] = score[1];
		if (n >= 2) {
			dp[2] = score[1] + score[2];
		}
		
		for (int i = 3; i <= n; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+score[i-1]) + score[i];
		}
		//2칸 이동: 이동하기 이전 값은 dp[i-2]
		//이전에 2칸을 이동해서(dp[i-3]) 1칸 이동한 계단 점수(score[i-1])
		//현재 계단을 왔다는 건 둘(이전이동의 경우의 수)의 비교와 상관없이 현재 계단 점수(score[i])가 들어간다
		
		System.out.println(dp[n]);
		
	} //main
} //class
