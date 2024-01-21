package 수학_p1010_다리놓기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine()); //테스트케이스
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			//그냥 m에서 순서 없이 n개를 고르면 됨. 
			//m5개 중 n2개 고르면 5*4 / 2*1  
			long ans = 1;
			for (int j = 0; j < n; j++) {
				ans *= m - j;
				ans /= j + 1;
			}
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
	} //main
} //class
