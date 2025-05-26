package com.stulikov.tasksFromInterview;

public class LengthAfterTransformations {

    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        int i = LengthAfterTransformations.lengthAfterTransformations("abcyy", 2);
        System.out.println(i);
    }

    public static int lengthAfterTransformations(String s, int t) {
            // Счётчик символов от 'a' до 'z'
            long[] count = new long[26];

            // Инициализация счётчика по изначальной строке
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }

            // Выполняем t трансформаций
            for (int step = 0; step < t; step++) {
                long[] next = new long[26];
                for (int i = 0; i < 26; i++) {
                    if (i == 25) { // 'z'
                        next[0] = (next[0] + count[25]) % MOD; // 'a'
                        next[1] = (next[1] + count[25]) % MOD; // 'b'
                    } else {
                        next[i + 1] = (next[i + 1] + count[i]) % MOD;
                    }
                }
                count = next;
            }

            // Суммируем все символы
            long total = 0;
            for (long c : count) {
                total = (total + c) % MOD;
            }

            return (int) total;
        }
}
