package BFSDFS_p16956_늑대와양;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * r*c 목장에는 양 S(이동 불가)/늑대 W(인접칸이동가능)/빈칸 .
 * 울타리 D 설치해서 늑대를 막을 수 있다면 1, 아니면 0
 * */
class Node{
	int r;
	int c;
	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
} //BFS - queue에서 사용할 것

public class Main {
	static int r; 
	static int c;
	static char[][] map;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static int ans = 1;
	
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());		
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();		
		} //입력
		
		bfs();
		
		System.out.println(ans);
		if (ans == 1) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					sb.append(map[i][j]);
				}
				sb.append('\n');
			}
			System.out.println(sb);
		}
		//SW가 붙어있으면 X, 한칸 건너뛰어있으면 사이에 D
		//늑대는 움직일 수 있으니까 s 양을기준으로 사방탐색?
	} //main
	
	public static void bfs() {
		Queue<Node> queue = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] == 'W') {
					queue.add(new Node(i,j)); //늑대 기준으로 확인
				}
			}
		}
		while (!queue.isEmpty()) {
			Node node = queue.poll(); //queue에서 꺼내기
			int nodeR = node.r;
			int nodeC = node.c;
			
			for (int k = 0; k < 4; k++) { //사방탐색
				int nr = nodeR + dr[k];
				int nc = nodeC + dc[k];
				
				if (nr >= 0 && nr < r && nc >= 0 && nc < c) {
					if (map[nr][nc] == 'S') {
						ans = 0;
						return; //늑대 옆에 바로 옆에 붙어있으면 무조건 0
					} else if (map[nr][nc] == '.') {
						map[nr][nc] = 'D'; //울타리는 그냥 어디 쳐도 이 문제에서는 ok
					}
				}
			}
		} //queue에 있는 것을 다 털 때까지
	} //bfs
} //class
