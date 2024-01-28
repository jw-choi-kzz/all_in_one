import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String search = br.readLine();
        boolean[] visited = new boolean[str.length()];
        int cnt = 0;
        //10글자에서 4글자짜리 찾기 0 1 2 3 4 5 6 / 7 8 9 = 10-4 = 6
        for (int i = 0; i <= str.length()-search.length(); i++) {
            if (str.charAt(i) == search.charAt(0) && !visited[i]) {
                for (int j = 0; j < search.length(); j++) {
                    if (str.charAt(i+j) != search.charAt(j)) {
                        break; //다름
                    } else {
                        if (str.charAt(i+j) == search.charAt(j) && search.length() == j+1) {
                            cnt++;
                            for (int k = 0; k < search.length(); k++) {
                                visited[i+k] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(cnt);
    } //main
} //class
