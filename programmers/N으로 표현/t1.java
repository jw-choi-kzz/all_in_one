/*
 * 숫자 N을 사용한 사칙연산으로 number를 표현할 때 N 사용횟수의 최솟값
 * <1> 12 = 5 + 5 + (5/5) + (5/5): "N의 배수" 10과 2일 때("1일 떼" N/N)를 더한 경우 
 * <2> 55/5 + 5/5: "11일 때"(위의 5+5+5/5 보다 최솟값)와 "1일때"를 더한 경우
 * <3> (55+5)/5: 5로 나눴을 때의 나머지가 0이고 몫이 2의 배수이면=> 그 수에서 5를 곱한 경우의 값. 
 * 55+5 같은건 결국 5*"12"
 * 완전히 다는 못품..
 */
import java.util.Arrays;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        int[] dp = new int [N*number+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 2;// = N/N
        dp[N] = N;
        for (int i = 2; i <= number; i++){
            if (i%N == 0){
                dp[i] = dp[i/N]+1;//10-> 5*(2) = 5*((5/5)+(5+5))->2일때+1
            } else {
                dp[i] = dp[N]*(i/N) + dp[i%N];//12-> 일때
            }
            
            
            
            dp[i] = Math.min(dp[i/N]+dp[i%N], dp[i/11]+dp[i%11]);
            System.out.println(dp[i]);
            //55
            // if (i%N == 0 || (i%())
            
        }
        
        if (dp[number] > 8){
            answer = -1;
        } else {
            answer = dp[number];
        }

        return answer;
    }
}
