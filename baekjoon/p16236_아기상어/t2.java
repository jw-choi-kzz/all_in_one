public class Main {
    static class point implements Comparable<point> {
        int r, c, size, distance; // 좌표, 상어 크기, 이동 거리
        public point(int r, int c, int size, int distance) {
            this.r = r; // 행 위치
            this.c = c; // 열 위치
            this.size = size; // 상어 크기
            this.distance = distance; // 이동 거리
        }
        
        @Override
        public int compareTo(point o) {
            if (this.distance != o.distance) return this.distance - o.distance; // 거리가 짧은 순으로 정렬
            else if (this.r != o.r) return this.r - o.r; // 행이 작은 순으로 정렬 (위쪽 우선)
            else return this.c - o.c; // 열이 작은 순으로 정렬 (왼쪽 우선)
        }
    } // 물고기 좌표 클래스

    static int n; // 전체 공간 크기
    static int[][] sea; // 전체 공간
    static boolean[][] visited; // 방문 처리 배열
    static int time; // 총 소요 시간
    static int cnt; // 먹은 물고기 수
    static int shark = 2; // 아기 상어의 크기
    static int nowR, nowC; // 현재 상어의 위치
    static int[] dr = {-1,1,0,0}; // 상하 이동
    static int[] dc = {0,0,-1,1}; // 좌우 이동

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // 전체 공간 크기 입력
        sea = new int[n][n]; // 전체 공간 배열 초기화
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken()); // 공간 정보 입력
                if (sea[i][j] == 9) { // 상어 위치 찾기
                    nowR = i; // 상어 행 위치
                    nowC = j; // 상어 열 위치
                    sea[i][j] = 0; // 상어 위치 초기화
                }
            }
        }
        cnt = 0; // 먹은 물고기 수 초기화
        time = 0; // 소요 시간 초기화

        for (;;) { // 무한 루프
            visited = new boolean[n][n]; // 방문 배열 초기화
            point search = BFS(new point(nowR, nowC, shark, time)); // BFS 탐색 실행
            if (search == null) { // 먹을 물고기가 없으면
                System.out.println(time); // 소요 시간 출력
                return; // 프로그램 종료
            }
            nowR = search.r; // 상어 위치 업데이트
            nowC = search.c; // 상어 위치 업데이트
            sea[nowR][nowC] = 0; // 물고기 먹은 위치 초기화
            cnt++; // 먹은 물고기 수 증가
            if (cnt == shark) { // 상어 크기만큼 물고기를 먹었으면
                shark++; // 상어 크기 증가
                cnt = 0; // 먹은 물고기 수 초기화
            }
            time = search.distance; // 이동 거리 업데이트
        }
    }

    public static point BFS(point start) {
        Queue<point> queue = new LinkedList<>();
        ArrayList<point> list = new ArrayList<>();
        queue.add(start); // 시작점 큐에 추가
        visited[start.r][start.c] = true; // 시작점 방문 처리

        while (!queue.isEmpty()) {
            point tmp = queue.poll(); // 큐에서 하나 꺼내기
            for (int i = 0; i < 4; i++) {
                int nr = tmp.r + dr[i]; // 다음 행 위치
                int nc = tmp.c + dc[i]; // 다음 열 위치

                // 조건 확인 (범위, 방문, 크기)
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc] || tmp.size < sea[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true; // 방문 처리
                queue.add(new point(nr, nc, tmp.size, tmp.distance + 1)); // 다음 위치 큐에 추가

                // 먹을 수 있는 물고기가 있으면 리스트에 추가
                if (sea[nr][nc] != 0 && tmp.size > sea[nr][nc]) {
                    list.add(new point(nr, nc, tmp.size, tmp.distance + 1));
                }
            }
        }

        Collections.sort(list); // 물고기 위치 정렬
        return list.isEmpty() ? null : list.get(0); // 가장 우선순위 높은 물고기 반환
    } // BFS 메서드
} // Main 클래스
