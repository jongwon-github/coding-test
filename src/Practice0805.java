public class Practice0805 {
    static int n, m, answer = Integer.MAX_VALUE;

    public void DFS(int L, int sum, int[] arr) {
        if (sum > m) return;
        else {
            if (sum == m) {
                answer = Math.max(answer, L);
                return answer;
            }
            for (int i = 0; i < n; i++) {
                DFS(++L, sum + arr[i], arr);
            }
        } 
    }

    public static void main(String[] args) {
        Practice0805 T = new Practice0805();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = kb.nextInt();
        m = kb.nextInt();
        T.DFS(0, 0, arr);
    }
}