package p11047_동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 동전 n종으로 k를 만드는 동전 최소 개수
 * "A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수" : 동전이 1, 2, 6 이런 식
 * 큰 동전부터 k랑 비교해서, 넣을 수 있으면 넣는다. 동전 사용 cnt는 나누기해서 몫을 더하고, 남은 돈은 나머지와 같음.
 */
public class Main {
      static int n; //동전 종류
      static int k; //목표 금액
      static int[] coin;
      public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            coin = new int[n]; //종류 n개의 금액 coin에 저장할 것
            for (int i = 0; i < n; i++){
                  coin[i] = Integer.parseInt(br.readLine()); //오름차순으로 coin에 입력됨
            } //입력 for문

            int ans = 0;
            for (int i = n-1; i >= 0; i--){
                  if (k >= coin[i]){
                        ans += (k / coin[i]);
                        k = (k % coin[i]);
                  } 
            }
            System.out.println(ans);
      }//main
}//class
