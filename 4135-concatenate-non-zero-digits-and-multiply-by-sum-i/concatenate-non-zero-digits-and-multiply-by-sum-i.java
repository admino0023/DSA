class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n);
        long x = 0;
        long sum = 0;
        for (char c : s.toCharArray())
        {
            int d = c -'0';
            sum += d;
            if(d != 0){
                x = x * 10 + d;
            }
        }
        return x * sum;
    }
}