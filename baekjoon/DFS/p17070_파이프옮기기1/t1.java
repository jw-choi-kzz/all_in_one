package DP_p17070_파이프옮기기1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n*n 집(r,c 번호는 1부터 시작), 빈칸이거나 벽
 * 파이프: (1,1) (1,2) →, ↘, ↓ 방향. 밀면서 회전(45도만)
 * 파이프 한 쪽 끝을 n,n으로 이동시키는 방법의 수 (없으면 0 출력)
 * 
 * 파이프 모습은 가로거나, 세로거나, 대각선인데 대각선은 모든 경우에 발생 가능
 * */
public class Main {
	static int n;
	static int[][] map;
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1]; //r,c 번호가 1번부터니까
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력
		
		ans = 0;
		DFS(1,2,0); //현재 끝쪽이 (1,2)에 있고 가로 모양인 상태로 재귀
		
		System.out.println(ans);
		
	} //main
	
	static void DFS(int r, int c, int direction) {
		//direction 0=가로.1=세로.2=대각선.
		//그때그때 가능한 경로를 찾아 재귀를 하면서 쭉  (n,n)이 될 때까지 가서 경우의 수 추가하고 리턴하기
		if (r == n && c == n) {
			ans++; //경우의 수 1 추가
			return; //리턴
		}
		
		switch (direction) {
		case 0:
			//가로->가로 이동: 그 옆으로 갈 수 있는지 = 범위(n) 내 & 벽이 아님
			if (c+1 <= n && map[r][c+1] == 0) {
				DFS(r,c+1,0);
			}
			break;
		case 1:
			//세로->세로 이동: 그 아래로 갈 수 있는지 = 범위(n) 내 & 벽이 아님
			if (r+1 <= n && map[r+1][c] == 0) {
				DFS(r+1,c,1);
			}
			break;
		case 2:
			//대각선->가로 / 세로 이동 = 각각  범위(n) 내 & 벽이 아님
			if (c+1 <= n && map[r][c+1] == 0) {
				DFS(r,c+1,0);
			}
			if (r+1 <= n && map[r+1][c] == 0) {
				DFS(r+1,c,1);
			}
			break;
		}
		
		//대각선은 기존 모양이 가로. 세로, 대각선 어떤 것이든 가능하기 때문에 따로 빼주기
		if (r+1 <= n && c+1 <= n && map[r+1][c+1] == 0 && map[r+1][c] == 0 && map[r][c+1] == 0) {
			DFS(r+1,c+1,2);
		}
	} //DFS
} //class
//어렵게 생각하지 말자!!!생각한대로 그대로 옮기자!! 
//결국 재귀로 만든 dfs는 범위 맞나 조건 체크 하면서 모든 경우에 대해 재귀를 하고 끝 지점 오면 리턴하고 이런 식이다
