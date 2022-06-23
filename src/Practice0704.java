public class Practice0704 {
    static int[] fibo;
    public int DFS(int n) {
        if (n == 1 || n == 2) return fibo[n] = 1;
        else return fibo[n] = DFS(n - 1) + DFS(n - 2);
    }

    public static void main(String[] args) {
        Practice0704 T = new Practice0704();
        int n = 5;
        fibo = new int[n + 1];
        T.DFS(n);
        for (int i = 1; i <= n; i++) {
            System.out.print(fibo[i] + " ");
        }
    }
}