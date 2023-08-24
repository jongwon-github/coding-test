import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class KakaoTest2 {

    public int transformRomanNumberalToNumber(String roman_numeral) {
        Map<Character, Integer> roman_char_dict = new HashMap<>();
        roman_char_dict.put('I', 1);
        roman_char_dict.put('V', 5);
        roman_char_dict.put('X', 10);
        roman_char_dict.put('L', 50);
        int res = 0;
        for (int i = 0; i < roman_numeral.length(); i++) {
            if (i == 0 || roman_char_dict.get(roman_numeral.charAt(i)) <= roman_char_dict.get(roman_numeral.charAt(i - 1)))
                res += roman_char_dict.get(roman_numeral.charAt(i));
            else
                res += roman_char_dict.get(roman_numeral.charAt(i)) - 2 * roman_char_dict.get(roman_numeral.charAt(i - 1));
        }
        return res;
    }

    public void solution(String[] s, int n) {
        //System.out.println(transformRomanNumberalToNumber(roman_numeral));
        // 두 개 모두를 배열로 담는다면??? -> 배열1 : 문자열, 배열2 : 로마숫자
        // 배열1 선택정렬???
        // compareTo 메소드를 사용하면 될거 같은데...
        String[] sArr1 = new String[n];
        String[] sArr2 = new String[n];
        for (int i = 0; i < n; i++) {
            String[] arr = s[i].split(" ");
            sArr1[i] = arr[0];
            sArr2[i] = arr[1];
        }

        // 여기서부터 로직 시작
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
//                string1 > string2인 경우: 양의 정수 반환
//                string1 < string2인 경우: 음의 정수 반환
//                string1 == string2인 경우: 0 반환
                String tmp = "";
                int compareVal = sArr1[i].compareTo(sArr1[j]);
                if (compareVal > 0) {
                    // 문자열 정렬
                    tmp = sArr1[i];
                    sArr1[i] = sArr1[j];
                    sArr1[j] = tmp;
                    // 로마숫자 정렬
                    tmp = sArr2[i];
                    sArr2[i] = sArr2[j];
                    sArr2[j] = tmp;
                } else if (compareVal == 0) {
                    //System.out.println("aaa");
                    //System.out.println(transformRomanNumberalToNumber(sArr2[i]));
                    //System.out.println(transformRomanNumberalToNumber(sArr2[j]));
                    if (transformRomanNumberalToNumber(sArr2[i]) > transformRomanNumberalToNumber(sArr2[j])) {
                        // 로마숫자 정렬
                        tmp = sArr2[i];
                        sArr2[i] = sArr2[j];
                        sArr2[j] = tmp;
                    }
                } else {
                    // 여기서는 아무거도 안해도 되나요???
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(sArr1[i] + " " + sArr2[i]);
        }
    }

    public static void main(String[] args) {
        KakaoTest2 k = new KakaoTest2();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] s = new String[n];
        kb.nextLine();
        for (int i = 0; i < n; i++) {
            s[i] = kb.nextLine();
        }
        k.solution(s, n);
    }
}
