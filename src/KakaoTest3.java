//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//
//class Test implements Comparable<Test> {
//    int hap, cnt, seq;
//
//    Test(int hap, int cnt, int seq) {
//        this.hap = hap;
//        this.cnt = cnt;
//        this.seq = seq;
//    }
//
//    @Override
//    public int compareTo(Test o) {
//        if (this.hap == o.hap) return this.cnt - o.cnt;
//        else return o.hap - this.hap;
//    }
//
//    int getHap() {
//        return hap;
//    }
//
//    int getCnt() {
//        return cnt;
//    }
//
//    int getSeq() {
//        return seq;
//    }
//}
//
//public class KakaoTest3 {
//    int[][] table = {{1, 1, 1}, {5 ,1, 1}, {25, 5, 1}};
//
//    public int solution(int[] picks, String[] minerals) {
//        int answer = 0;
//
//        int picksCnt = 0;
//        for (int n : picks) {
//            picksCnt += (n * 5);
//        }
//        if (picksCnt > minerals.length) picksCnt = minerals.length;
//
//        int hap = 0;
//        int cnt = 0;
//        int seq = 0;
//        ArrayList<Test> list = new ArrayList<>();
//        for (int i = 0; i < picksCnt; i++) {
//            switch (minerals[i]) {
//                case "diamond":
//                    hap += 25;
//                    break;
//                case "iron":
//                    hap += 5;
//                    break;
//                case "stone":
//                    hap += 1;
//                    break;
//            }
//
//            cnt++;
//
//            if (((i + 1) % 5) == 0) {
//                list.add(new Test(hap, cnt, seq++));
//                hap = 0;
//                cnt = 0;
//            }
//        }
//        if (picksCnt % 5 != 0) list.add(new Test(hap, cnt, seq));
//        Collections.sort(list);
//
//
//        for (int i = 0; i < list.size(); i++) {
//            int s = list.get(i).getSeq();
//            for (int j = s * 5; j < (s * 5) + 4; j++) {
//                if (j > minerals.length) break;
//
//            }
//        }
//
//        return answer;
//    }
//
//    // 곡갱이 배열도 만들어 버릴까???
//    public void getTest() {
//        for (int n : picks) {
//            if (n > 0) {
//                while (n > 0) {
//
//                    n--;
//                }
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        KakaoTest3 T = new KakaoTest3();
//        Scanner kb = new Scanner(System.in);
//        int[] picks = {1, 1, 0};
//        String[] minerals = {"iron", "iron", "diamond", "iron", "stone", "diamond", "diamond", "diamond"};
//        T.solution(picks, minerals);
//    }
//}
