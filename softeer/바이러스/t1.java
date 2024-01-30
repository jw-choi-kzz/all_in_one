import java.io.*;
import java.util.*;
/*
 * 처음 k마리가 1초당 p배씩 증가한다면 n초 후에는 얼마나 불어나는지 계산
 * 제약조건 보면 정수가 크기 때문에 long으로 만들어야 할 듯
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long k = sc.nextLong();
        long p = sc.nextLong();
        int n = sc.nextInt();

        long[] res = new long[n+1];
        res[0] = k;
        for (int i = 1; i <= n; i++){
            res[i] = res[i-1] * p;
        }

        long tmp = 10000000007L;
        
        long ans = res[n]%tmp;
        
        System.out.println(ans);
        // System.out.println(res[n]%10000000007L);
    } //main
} //class
