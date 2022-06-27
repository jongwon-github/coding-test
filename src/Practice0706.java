public class Practice0706 {
    static int n;
    static int[] ch;
    public void DFS(int L) {
        if (L == n + 1) {

        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }

    public static void main(String[] args) {
        Practice0706 T = new Practice0706();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
    }
}
