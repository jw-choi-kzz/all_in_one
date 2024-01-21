for (;;) { // 무한 루프
    boolean found = false;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (map[i][j] == 0 || map[i][j] == 9) continue;
            if (map[i][j] < shark_size) {
                found = true; // 작은 물고기를 찾았음
                break;
            }
        }
        if (found) break; // 작은 물고기를 찾았으면 반복문 종료
    }

    if (!found) {
        System.out.println(total_dist); // 더 이상 먹을 물고기가 없으면 종료
        return;
    }

    // 이하 로직은 동일하게 유지
    visited = new boolean[N][N]; // 방문 배열 초기화
    Node move = BFS(new Node(shark_x, shark_y, shark_size, total_dist));
    if (move == null) { // 물고기를 못 찾았으면
        System.out.println(total_dist);
        return;
    }

    // 물고기를 찾았으면 상어 위치 업데이트
    shark_x = move.x;
    shark_y = move.y;
    map[move.x][move.y] = 0; // 물고기 위치는 0으로 갱신
    count_eat++; // 물고기 먹은 수 증가
    if (count_eat == move.size) { // 먹은 수와 상어 사이즈가 같으면
        shark_size = move.size + 1; // 상어 사이즈 증가
        count_eat = 0; // 먹은 횟수 초기화
    }
    total_dist = move.dist; // 이동 거리 업데이트
}
