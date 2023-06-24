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
        /**
         * '과일 가져가기' 문제 중, 과일을 교환할 수 있는 경우
         * 0번 인덱스 : 사과, 1번 인덱스 : 배, 2번 인덱스 : 귤
         * 1. 각 학생의 가장 적은 과일의 수가 유니크 해야 한다.
         * 2. 교환하고자 하는 인덱스값이 달라야 한다. -> 교환하려는 과일의 종류가 달라야 한다. -> 동일한 종류의 과일을 교환해봤자 값은 그대로이기 때문
         * 3. 교환 후에도 해당 인덱스값(과일의 갯수)이 최소값을 유지해야 한다.
         */
        int answer = 0;
        int[] ch = new int[fruit.length];
        for (int i = 0; i < fruit.length - 1; i++) {
            if (ch[i] == 1) continue; // 이미 과일을 교환했다는 의미
            if (!isMinUnique(fruit[i])) continue; // 학생이 가지고 있는 과일의 최소값이 유니크 하지 않다는 의미
            for (int j = i + 1; j < fruit.length; j++) {
                if (ch[j] == 1) continue; // 이미 과일을 교환했다는 의미
                if (!isMinUnique(fruit[j])) continue; // 학생이 가지고 있는 과일의 최소값이 유니크 하지 않다는 의미
                int idx1 = getMinIndex(fruit[i]);
                int idx2 = getMinIndex(fruit[j]);
                if (idx1 != idx2 && fruit[i][idx2] > 0 && fruit[j][idx1] > 0) { // 각 학생이 가지고 있는 최소 과일의 종류가 다르고 교환할 과일의 수가 존재하는 경우
                    if (fruit[i][idx1] + 1 <= fruit[i][idx2] - 1 && fruit[j][idx2] + 1 <= fruit[j][idx1] - 1) { // 과일 교환 후에도 기존의 최소 과일 종류가 동일한지 체크
                        fruit[i][idx1]++;
                        fruit[i][idx2]--;
                        fruit[j][idx2]++;
                        fruit[j][idx1]--;
                        ch[i] = 1;
                        ch[j] = 1;
                        break;
                    }
                }
            }
        }
        for (int[] eachStudentHave : fruit) {
            answer += getMin(eachStudentHave);
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
