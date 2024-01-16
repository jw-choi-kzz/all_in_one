package 수학_유클리드호제법;
/*
 * 유클리드 호제법 : 최대공약수를 빠르게 구하는 방법
 * (a > b일 때) a % b = r이면, a와 b의 최대공약수 = b와 r의 최대공약수
 */
public class Code {
	//코드로 구현
	public static int gcd(int p, int q)  { //이 때 p > q이어야 함)
		if (q == 0)  {  //위의 26, 12 예시에서 2 % 0(q) 인 상황.
			return p; // 최대공약수 p 리턴
		}
		return gcd(q, p%q); //q가 0이 아니라면 다시 q와 'p를 q로 나눈 나머지'를 두고 반복
	}
}

/*
 * 최소공배수: 두 수의 최대공약수 * 두 수의 나머지들 = 두 수의 곱/최대공약수
 */
