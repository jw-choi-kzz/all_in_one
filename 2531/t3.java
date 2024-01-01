//블로그 참고했는데 블로그가 틀림;
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
		
		int[] belt = new int [n];//초밥 벨트
		for (int i = 0; i < n; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}//초밥 종류 입력
		
		//그러고보니 초밥 가짓수 d는 어디에?
		int[] chk = new int [d+1];//먹은 초밥 확인
		
		//ans 초기값 설정
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			int now = belt[i];//지금 초밥
			if (chk[now] == 0) {
				//아직 안 먹은 초밥 종류
				cnt++;
			}
			chk[now]++;//해당 초밥 종류 먹었다고 체크
		}
		int ans = cnt;//(입력받은대로) 0~ k-1번째 초밥까지 먹었을 때의 값으로 초기화
		
		for (int i = 0; i < n-1; i++) {
			if (cnt >= ans) {
				if (chk[c] == 0) {
					ans = cnt + 1;
				} else {
					ans = cnt;
				}
			}			
			
			//시작점 초밥 빼기
			chk[belt[i]]--;
			
			if (chk[belt[i]] == 0) {
				cnt--;
			}
			
			//끝점 초밥이 중복인지 확인
			if (chk[belt[(i+k)%n]] == 0) {
				cnt++;
			}
			
			//끝점 초밥 추가하기
			chk[belt[(i+k)%n]]++;
			
//			if (chk[c] == 0) {
//				ans = Math.max(cnt+1, ans);
//			} else {
//				ans = Math.max(cnt, ans);
//			}
		}
		
		
		System.out.println(ans);
	}//main
}//class
