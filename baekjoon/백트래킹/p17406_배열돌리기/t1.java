package p17406_배열돌리기4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n*m 배열의 값은 각 행(가로줄)에 있는 모든 수의 합 중 최소값 출력
 * 회전 연산: r c s => 왼위 모서리(r-s,c-s) ~ 오아(r+s,c+s) 정사각형을 시계방향으로 한칸씩 돌린다
 * r-s ~ r ~ r+s / c-s ~ c c+s   
 * 입력: n, m, 회전 연산 횟수 k / 배열 (n줄) / k 줄에 각각 r c s 
 * 회전 연산은 모두 한 번씩 사용해야 하며, 순서는 임의로 정해도 된다 = 순서를 바꿔도 된다....
 * 
 *  throws IOException 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 * = Integer.parseInt(br.readLine());
 * StringTokenizer st = new StringTokenizer(br.readLine());	
 * = Integer.parseInt(st.nextToken());
 * */
public class Main {
	
	static int n; //r
	static int m; //c
	static int k; //회전 연산 횟수(1~6)
	static int[][] arr; //처음 배열 입력
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0}; //우 하 좌 상	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}			
		} //입력
		
		//회전 연산을 굳이 반복문으로 돌릴 필요가 있을까?? k번을 한번에 처리하는 방법..
		//근데 또 rcs 가 계속 바뀌니까 어려울수도..
		for (int i = 1; i <= k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			//r-s, c-s에서 연산 시작해서 한 바퀴 돌고, 
		}
		
	} //main
	
	public static void rotation(int r, int c, int s) {
		//시계방향(달팽이 문제?)으로 돌고, (r,c)는 고정. => 시계방향 도는거는 s번 수행하게 됨
		//가다가, r+s c+s 넘어가면 방향바꿈 drdc 배열
		r = r-s;
		c = c-s;
		int d = 0; //델타 배열 인덱스 조정
		//반복문 건을 
		
	} //rotation
} //class


/*
5 6 2
1 2 3 2 5 6
3 8 7 2 1 3
8 2 3 1 4 5
3 4 5 1 1 1
9 3 2 1 4 3
r3 c4 s2 : (*0부터 아님 주의)
(r-s, c-s) = (1,2)  
(r+s, c+s) = (5,6) 
1 [8] [2] [3] [2] [5]
3 [2] [3] [7] [2] [6]
8 [4] [5] [1] [1] [3]
3 [3] [1] [1] [4] [5]
9 [2] [1] [4] [3] [1]
-------------
r4 c2 s1 => (3,1) ~ (5,3)
1 8 2 3 2 5
3 2 3 7 2 6
[3] [8] [4] 1 1 3
[9] [3] [5] 1 4 5
[2] [1] [1] 4 3 1
=============
21
23
20
27
12 **정답
 * */
