import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int money = 1000 - n;
        int cnt = 0;
        if (money/500 > 0) {
            cnt += money/500;
            money %= 500;
        }
        if (money/100 > 0) {
            cnt += money/100;
            money %= 100;
        }
        if (money/50 > 0) {
            cnt += money/50;
            money %= 50;
        }
        if (money/10 > 0) {
            cnt += money/10;
            money %= 10;
        }
        if (money/5 > 0) {
            cnt += money/5;
            money %= 5;
        }
        System.out.println(cnt + money);
    } //main
} //class
