package p2751_수정렬하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		int[] num = new int[n]; //일반 리스트로 하고 Arrays.sort 하면 시간초과
		ArrayList<Integer> num = new ArrayList<>(); //이럴 땐 ArrayList로 만들고, 이때의 정렬은 Collections.sort 사용
		for(int i = 0; i < n; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(num);
		
		StringBuilder sb = new StringBuilder();
		for(Integer number : num) {
			sb.append(number).append('\n');
		}
		
		System.out.println(sb);
		
	}
}
