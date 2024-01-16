package 수학_p5618_공약수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 자연수 n개의 공약수를 모두 구함
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //2 또는 3
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		} //입력
		Arrays.sort(num);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= num[0]; i++) {
			boolean chk = true;
			for (int j = 0; j < n; j++) {
				if (num[j] % i != 0) {
					chk = false;
					break;
				} else {
					chk = true;
				}
			}
			if (chk) {
				sb.append(i).append('\n');				
			}
		}
		System.out.println(sb);
		
	} //main
} //class
