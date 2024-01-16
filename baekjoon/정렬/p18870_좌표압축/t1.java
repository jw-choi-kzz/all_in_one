//시간초과. HashSet 사용
package sort_p18870_좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/*
 *  X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		} //입력
		
		int[] ans = new int[n];
		
		for (int i = 0; i < n; i++) {
			HashSet<Integer> hashset = new HashSet<>();
			for (int j = 0; j < n; j++) {
				if (i != j && num[i] > num[j]) {
					hashset.add(num[j]);
				}
			}
			ans[i] = hashset.size();
		} //입력
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n-1; i++) {
			sb.append(ans[i]).append(' ');
		}
		sb.append(ans[n-1]);
		System.out.println(sb);
	} //main
} //class
