import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CdTest0205 {
    public String solution(String[] votes, int k){
        String answer = " ";

        /**
         * john이 tom을 추천 했다면 [john, tom]의 순써쌍 입력정보가 들어옴
         * voteHash : key -> john, value -> tom
         * candidate : key -> tom, value -> key 값을 추천한 학생 수
         * present : key -> john, value -> key 값이 추천한 사람 중, k 값보다 크거나 같은 수 많큼 추천 받은 학생 수
         */
        HashMap<String, HashSet<String>> voteHash = new HashMap<>();
        HashMap<String, Integer> candidate = new HashMap<>();
        HashMap<String, Integer> present = new HashMap<>();

        for (String vote : votes) {
            String[] names = vote.split(" ");
            /**
             * putIfAbsent 메소드란?
             * - Key 값이 존재하는 경우 : Map의 Value 값 반환
             * - Key 값이 존재하지 않는 경우 : Key와 Value를 Map에 저장하고 Null을 반환
             */
            voteHash.putIfAbsent(names[0], new HashSet<>());
            voteHash.get(names[0]).add(names[1]);
            candidate.put(names[1], candidate.getOrDefault(names[1], 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        for (String voteHashKey : voteHash.keySet()) {
            int cnt = 0;
            for (String candidateName : voteHash.get(voteHashKey)) {
                if (candidate.get(candidateName) >= k) cnt++;
            }
            present.put(voteHashKey, cnt);
            max = Math.max(max, cnt);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String name : present.keySet()) {
            if (present.get(name) >= max) tmp.add(name);
        }
        tmp.sort((a, b) -> a.compareTo(b));
        answer = tmp.get(0);

        return answer;
    }

    public static void main(String[] args) {
        CdTest0205 T = new CdTest0205();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
