class Solution {
    static final int MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] val = new long[n + 1];
        int[] cnt = new int[n + 1];
        long[] sumPrefix = new long[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 0; i < n; i++) {
            int d = s.charAt(i) - '0';
            int e = (d != 0) ? 1 : 0;
            val[i + 1] = (val[i] * (e == 1 ? 10L : 1L) + d) % MOD;
            cnt[i + 1] = cnt[i] + e;
            sumPrefix[i + 1] = sumPrefix[i] + d;
        }

        int q = queries.length;
        int[] answer = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0], r = queries[i][1];
            int k = cnt[r + 1] - cnt[l];
            long x = (val[r + 1] - val[l] * pow10[k]) % MOD;
            if (x < 0) x += MOD;

            long sum = (sumPrefix[r + 1] - sumPrefix[l]) % MOD;

            long ans = (x * sum) % MOD;
            answer[i] = (int) ans;
        }

        return answer;
    }
}