package p16236_아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * n*n 에 물고기 m 마리, 아기상어(처음 크기 2) 한마리
 * 아기상어는 1초에 상하좌우 인접한 한칸씩 이동
 * 상어 이동은 자기보다 작거나 같은 크기 물고기있는 곳 가능. 
 * 먹는건 자기와 가장 가까운, 자신보다 작은 물고기. (거리=지나가는 칸 개수 최소값)(가장 위에 있고 -> 가장 왼쪽에 있는 물고기)
 * 아기상어 크기와 같은 수의 물고기를 먹을때마다 크기 1 증가.
 * 
 * 입력: 0은 빈칸, 1,2,3,4,5,6 물고기 크기, 아기상어 위치=9
 * 출력: 아기상어가 몇 초동안 물고기를 먹을 수 있는지
 * 
 * BFS를 
 * */
public class Main {
	
	//아예 비교 기준을 좌표 클래스에 넣어버리자
	//가장 가까운, 자기보다 작은 물고기. 만약 여러개면 가장 위에, 그래도 많으면 가장 왼쪽
	static class point implements Comparable<point> {
		int r;
		int c;
		int size;
		int distance;
		public point(int r, int c, int size, int distance) {
			this.r = r;
			this.c = c;
			this.size = size;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(point o) {
		    if (this.distance != o.distance) {
		        return this.distance - o.distance; // 거리 순으로 정렬
		    } else if (this.r != o.r) {
		        return this.r - o.r; // 거리가 같으면 더 위에 있는 순서
		    } else {
		        return this.c - o.c; // 위치가 같으면 더 왼쪽에 있는 순서
		    }
		}
	} //물고기 좌표
	
	static int n; //전체 공간 크기
	static int[][] sea; //전체 공간
	static boolean[][] visited; //전체 공간 방문처리
	static int time; //정답(물고기 잡아먹을 수 있는 시간)
	static int cnt; //얼마나 먹었나(shark와 같아지면 다시 0으로, shark와 eatable는 +1)
	static int shark = 2; //아기상어 크기
	static int nowR;
	static int nowC; //상어 위치
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1}; //델타 상하좌우
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		sea = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());	
			for (int j = 0; j < n; j++) {
				sea[i][j] = Integer.parseInt(st.nextToken());
				if (sea[i][j] == 9) {
					nowR = i;
					nowC = j; //현재 아기상어 위치 저장
					sea[i][j] = 0; //상어 있던 곳도 0 처리
				} 
			}			
		} //입력 완료
		cnt = 0;
		time = 0;
				
		//현재 아기상어의 상하좌우에 아기상어보다 작거나 같은 칸이 있다면 이동 nowR,nowC 이동
		//(만약 작으면 먹어서 cnt++, fist[방금 먹은 물고기 크기]--, sea[해당 위치] = 0, 
		
		for ( ; ; ) {
			visited = new boolean[n][n];
			point search = BFS(new point(nowR, nowC, shark, time));
			if (search == null) {
				System.out.println(time);
				return; //무한루프 끝
			}
			
			nowR = search.r;
			nowC = search.c;
			sea[nowR][nowC] = 0;
			cnt++;
			if (cnt == shark) {
				shark++;
				cnt = 0;
			}
			time = search.distance;
		}
		
		
	} //main
	
	//BFS로 탐색
	public static point BFS(point start) {
		Queue <point> queue = new LinkedList<>();
		ArrayList <point> list = new ArrayList<>();
		queue.add(start); //queue에 넣고
		visited[start.r][start.c] = true; //방문처리
		
		while (!queue.isEmpty()) {
			point tmp = queue.poll(); //하나 완전히 꺼내서
			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || tmp.size < sea[nr][nc]) {
					continue;
				} //범위 밖이거나, 방문 이미 한 곳이거나, 크기가 커서 못먹는 친구
				visited[nr][nc] = true; //이동 가능한 곳이면 방문처리하고
				queue.add(new point(nr, nc, tmp.size, tmp.distance+1)); //queue에 넣음
				if (sea[nr][nc] != 0 && tmp.size > sea[nr][nc]) {
					list.add(new point(nr, nc, tmp.size, tmp.distance+1));
				}
			}
		}
		
		Collections.sort(list);
		return list.isEmpty() ? null : list.get(0);
	} //BFS
	
} //class
