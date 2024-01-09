package p2108_통계학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int [n];
		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			sum += num[i];
		}
		sb.append((int)Math.round((double)sum/n)).append('\n'); //최빈값
		Arrays.sort(num);
		sb.append(num[n/2]).append('\n'); //중앙값
		
		//**최빈값 구하기 1 카운팅배열 생성
		int[] cnt = new int[8001];//-4000 ~ 0 ~ 4000
		for (int i = 0; i < n; i++) {
			cnt[num[i]+4000]++;
		}		
		//** 2 가장 높은 빈도수 체크
		int max = 0;
		for (int i = 0; i < 8001; i++) {
			max = Math.max(max, cnt[i]);
		}
		//** 3 ArrayList 만들어서 같은 빈도수 나온 모든 수 저장
		ArrayList<Integer> list = new ArrayList<>();
		for (int i : num) {
			if (cnt[i+4000] == max && !(list.contains(i))) {
				list.add(i);
			}
		}
		//** 4 최빈값 2개 이상이면 두 번째로 작은 수 출력
		if (list.size()>=2) {
			sb.append(list.get(1)).append('\n');
		} else {
			sb.append(list.get(0)).append('\n');
		}
		
		
		sb.append(num[n-1]-num[0]); //범위
		
		System.out.println(sb);
	} //main
} //class
