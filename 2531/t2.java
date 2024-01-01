//시간초과(for문 사용)
//벨트 위 초밥 저장할 때 미리 배열의 길이를 범위 벗어나는 경우만큼 늘려서 저장
//if문 간단하게 수정

package p2531_회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 * 손님이 먹을 수 있는 초밥 가짓수의 최대값 구하는 문제
 * 행사 1: 벨트에서 k개의 접시 연속 먹으면 할인된 정액 가격으로 제공
 * 행사 2: 행사 1 참여 시 쿠폰에 적힌 초밥 종류 무료 제공
 * [입력] 첫 줄: 벨트에 놓인 접시 수 n, 초밥 가짓수 d, 행사 1 연속 접시 수 k, 행사 2 쿠폰  번호 c / 
 * 		 두 번째 줄~(n개 줄): 벨트 한 위치부터 회전 방향에 따른 초밥 종류 1개씩
 * 벨트 위에는 같은 종류 초밥이 둘 이상 있을 수 있음
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());//벨트에 놓인 접시 수 n
		int d = Integer.parseInt(st.nextToken());//초밥 가짓수 d
		int k = Integer.parseInt(st.nextToken());//행사 1 연속 접시 수 k
		int c = Integer.parseInt(st.nextToken());//행사 2 쿠폰  번호 c
		
		int[] belt = new int [n+k-1];//초밥 벨트
		for (int i = 0; i < belt.length; i++) {
			if (i < n) {
				belt[i] = Integer.parseInt(br.readLine());
			} else {
				belt[i] = belt[i-n];
			}
		}//초밥 종류 입력
		
		
		int ans = 0;//최대값
		for (int i = 0; i < n; i++) {
			HashSet <Integer> hashset = new HashSet();
			for (int j = i; j < i+k; j++) {
				if (!hashset.contains(belt[j])) {
					hashset.add(belt[j]);
				}
			}//연속 k개

			if (hashset.contains(c)) {
				ans = Math.max(ans, hashset.size());
			} else {
				ans = Math.max(ans, hashset.size()+1);
			}//행사 2 쿠폰
		}
		System.out.println(ans);
	}//main
}//class
