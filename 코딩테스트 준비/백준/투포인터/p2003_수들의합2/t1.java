import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n개의 수
        m = Integer.parseInt(st.nextToken()); //목표 구간 합
        num = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        //구간 합이 m인 곳을 찾기 위한 투 포인터(s = 0, e = 0에서 시작, sum)
        int s = 0; //포인터 1
        int e = 0; //포인터 2
        int sum = 0; //구간 합
        int cnt = 0; //경우의 수
        while (true) {
            if (sum >= m) {
                //첫 번째 포인터를 뒤로 하나 이동
                sum -= num[s++];
            } else if (e == n) {
                //두 번째 포인터가 끝에 닿았다 = 탐색 종료
                break;
            } else {
                //두 번째 포인터를 뒤로 하나 이동
                sum += num[e++];
            }
            
            if (sum == m) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
