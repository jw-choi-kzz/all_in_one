//package 문자열_p16171_나는친구가적다small;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문자열, 문자열키워드 주어지면 첫 줄에 키워드가 존재하면 1, 아니면 0
 * 빈 문자열 생성 후 += 문자 붙이기 가능
 *
 * [모르던 부분]
 * 문자열.contains(비교할문자열) => 포함되었는지 확인 가능
 * 문자열.indexOf(비교할문자열) => 포함되었으면 해당 문자열의 시작인덱스를 반환하고, 아니면 -1을 반환
 * */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		int ans = 0;
		int idx1 = 0;
		int idx2 = 0;
		while (idx1 < str1.length) {
			if (str1[idx1] == str2[idx2]) {
//				System.out.println("같은거 발견: "+str1[idx1]);
				sb.append(str1[idx1]);
				idx1++;
				idx2++;
			} else {
//				System.out.println("달라: "+str1[idx1]+" & "+str2[idx2]);
				//숫자면 str1만 인덱스 넘겨
				if (str1[idx1] >= '0' && str1[idx1] <= '9') {
					idx1++;
				} else {
					//문자면 str1는 넘기고 str2는 0으로 돌아가
					idx1++;
					idx2 = 0;
				}
			}
			if (idx2 == str2.length) {
				ans = 1;
				break;
			}
		} //while
		
		System.out.println(ans);
	} //main
} //class
