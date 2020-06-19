package com.wushuang.algorithm;

/**
 * 寻找回文素数
 *
 * @author <a href="jiaotou@2dfire.com">jiaotou</a>
 * @date 2020/6/19 10:51
 */
public class FindPrimePalindromeDemo {

    public static int primePalindrome(int N) {
        while (true) {
            if (N == reverse(N) && isPrime(N)) {
                return N;
            }

            N++;
            // 不存在8位数的素数，因此可以跳过
            if (10_000_000 < N && N < 100_000_000) {
                N = 100_000_000;
            }
        }
    }

    /**
     * 判断是否是素数
     *
     * @param N
     * @return
     */
    public static boolean isPrime(int N) {
        if (N < 2) {
            return false;
        }
        int R = (int) Math.sqrt(N);
        for (int d = 2; d <= R; ++d) {
            if (N % d == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断是否是回文字符串
     *
     * @param N
     * @return
     */
    public static int reverse(int N) {
        int ans = 0;
        while (N > 0) {
            ans = 10 * ans + (N % 10);
            N /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(primePalindrome(1000));
    }

}
