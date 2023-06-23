public class CdTest0106 {
    public int getMin(int[] fruit){
        int min = 100;
        for(int x : fruit){
            min = Math.min(min, x);
        }
        return min;
    }

    public Boolean isMinUnique(int[] fruit){
        int cnt = 0;
        int min = getMin(fruit);
        for(int x : fruit){
            if(x == min) cnt++;
        }
        return cnt == 1;
    }

    public int getMinIndex(int[] fruit){
        int min = getMin(fruit);
        for(int i = 0; i < 3; i++){
            if(fruit[i] == min) return i;
        }
        return 0;
    }

    public int solution(int[][] fruit){
        int answer = 0;
        int[] ch = new int[fruit.length];
        for (int i = 0; i < fruit.length - 1; i++) {
            if (ch[i] == 1) continue; // 이미 과일을 교환했다는 의미
            if (!isMinUnique(fruit[i])) continue; //
            for (int j = i + 1; j < fruit.length; j++) {
                if (ch[j] == 1) continue; // 이미 과일을 교환했다는 의미
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        CdTest0106 T = new CdTest0106();
        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }
}
