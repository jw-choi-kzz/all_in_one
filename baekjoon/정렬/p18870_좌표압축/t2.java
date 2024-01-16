//HashMap 사용: key로 주어진 숫자, value로 해당 key값의 등수(0부터 시작)
package sort_p18870_좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 *  X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표 Xj의 개수와 같아야 한다.
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n]; //입력
		int[] tmp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			tmp[i] = num[i];
		} //입력
		
		Arrays.sort(tmp); //오름차순 정렬하고		
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		int rank = 0; //0에서 순위시작
		for (int v: tmp) {
			if (!(hashmap.containsKey(v))) { //중복되는 수인지 확인하고
				hashmap.put(v, rank); //중복된 수가 아니면 hashmap에 put: 수를 key 값으로, value는 순위()
				rank++; //다음에 오는 수는 1 높아진 순위 배정될 예정
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (int key: num) {
			int ranking = hashmap.get(key);
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
	} //main
} //class
