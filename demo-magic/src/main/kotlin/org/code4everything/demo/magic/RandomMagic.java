package org.code4everything.demo.magic;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * @author pantao
 * @since 2022/6/6
 */
public class RandomMagic {

    public static void main(String[] args) {
        sayILoveYou();
    }

    public static void sayILoveYou() {
        List<Long> seeds = Arrays.asList(-9223372036854775514L, -9223372036848384275L, -9223372036854652369L);
        for (Long seed : seeds) {
            System.out.print(randomString(seed) + " ");
        }
    }

    public static String randomString(long seed) {
        Random ran = new Random(seed);
        StringBuilder sb = new StringBuilder();
        while (true) {
            int k = ran.nextInt(27);
            if (k == 0)
                break;

            sb.append((char) ('`' + k));
        }
        return sb.toString();
    }

    public static long generateSeed(String word) {
        char[] input = word.toCharArray();
        char[] pool = new char[input.length];
        label:
        for (long seed = Long.MIN_VALUE; seed < Long.MAX_VALUE; seed++) {
            Random random = new Random(seed);

            for (int i = 0; i < input.length; i++)
                pool[i] = (char) (random.nextInt(27) + '`');

            if (random.nextInt(27) == 0) {
                for (int i = 0; i < input.length; i++) {
                    if (input[i] != pool[i])
                        continue label;
                }
                return seed;
            }
        }
        throw new NoSuchElementException("Sorry :/");
    }
}
