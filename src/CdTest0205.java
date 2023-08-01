package org.example;

import java.util.HashMap;
import java.util.HashSet;

public class CdTest0205 {
    public String solution(String[] votes, int k){
        String answer = " ";
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
        for (String voteHashKey : voteHash.keySet()) {
            for (String candidateName : voteHash.get(voteHashKey)) {
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CdTest0205 T = new CdTest0205();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
    }
}
