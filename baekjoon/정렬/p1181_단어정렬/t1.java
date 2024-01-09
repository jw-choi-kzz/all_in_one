package p1181_단어정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] list = new String[n];
		for (int i = 0; i < n; i++) {
			list[i] = br.readLine();
		}
		
		Arrays.sort(list,(String o1,String o2)->{
			if (o1.length() == o2.length() ) {
				return o1.compareTo(o2); //compareTo: 두 문자열 간 사전식 비교 기반 int 반환
        //문자열에서 동일한 위치에 있는 문자를 순차적으로 비교
        //문자열이 같으면 0 반환
			} else {
				return o1.length() - o2.length();
			}
		});
		
		//중복 제거하며 sb에 넣고 출력
		StringBuilder sb = new StringBuilder();
		sb.append(list[0]).append('\n');
		for (int i = 1; i < n; i++) {
			if (!(list[i-1].equals(list[i]))) {
				sb.append(list[i]).append('\n');
			} 
		}//0 1 2 3
		System.out.println(sb);
		
	} //main
} //class
