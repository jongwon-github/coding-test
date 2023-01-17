import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int s, h, w; // 넓이, 높이, 무게

    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }

    @Override
    public int compareTo(Brick o) {
        // 넓이를 기준으로 내림차순 정렬
        return o.s - this.s;
    }
}
public class Practice1004 {
    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        int answer = 0;
        Collections.sort(arr);
        dy[0] = arr.get(0).h;
        // 첫 번째 벽돌이 넓이, 무게가 가장 큰 경우, 아래 반복문 실행이 되지 않기 때문에 초기값을 세팅
        answer = dy[0];
        for (int i = 1; i < arr.size(); i++) {
            int max_h = 0;
            for (int j = i; j >= 0; j--) {
                if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) max_h = dy[j];
            }
            dy[i] = max_h + arr.get(i).h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Practice1004 T = new Practice1004();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n];
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.println(T.solution(arr));
    }
}
