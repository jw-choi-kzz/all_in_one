package p15486_퇴사2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n일, 하루에 하나씩 서로 다른 사람 상담, 각 상담 완료하는데 걸리는 기간 t, 금액 p
 * 퇴사 전까지 최대 수익
 */
public class Main {
	static int n; //일하는 기간
	static int[][] info; //기간, 금액
	static int max = 0; //최대 수익
	static int[] dp; //해당 날짜까지 얻을 수 있는 수익?
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine()); //일하는 기간
		info = new int[n][2]; //기간, 금액
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		} //입력
		
		dp = new int[n+1];
		for (int i = 1; i <= n; i++) {
			if (info[i][0] > n-i) {
				dp[i] = dp[i-1];
				continue; //퇴사 전까지 못끝내는 일이면 그 일은 못함.
			} else {
				if (info[i][0] > 1) {
					dp[i] = dp[i-1]; //전날 수익
					dp[i+info[i][0]] = dp[i]+info[i][1];
					//6일에 dp[1]0+info[1][1]20 한 것과 dp[3]10+info20+15한 것 비교
				} else {
					//그날 처리 가능한 당일치기 상담이라면
					dp[i] = Math.max(dp[i-1] +info[i][1], );
				}
			}
		}
		
	} //main
} //class

/*
 * 1 /2 /3 /4 /5 /6 /7일
 * 3 /5 /1 /1 /2 /4 /2일걸림
 * 10/20/10/20/15/40/200 수익
 * 
 * 1일에는 t가 1보다 커서 아직 수익 없음, 만약 3일치 상담한다면 3일에 얻는 수익은 10
 * 2일도 t가 1보다 커서, 2일에 들어온 일을 하려면 1일의 일을 못함. 대신 5일 뒤인 6일까지 수익 20
 * 3일은 t가 1이라 앞에거 일들 안하고 3일에 들어온 일 했다면 3일까지 번 수익 10. 이건 1일때 구한 3일까지의 수익과 비교. = 3일치까지의 최대치는 10
 * 4일은 t가 1이라 1일에 들어온 일 또는 3일에 들어온 일 하고, 4일에 들어온 일까지 해서 4일치에 번 수익은 전날까지의 수익+20 = 30
 * 5일은 t가 2라 당일에는 못벌고, 그 전날
 * */
