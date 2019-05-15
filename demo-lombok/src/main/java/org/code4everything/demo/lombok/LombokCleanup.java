package org.code4everything.demo.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;

import java.io.InputStreamReader;

/**
 * @author pantao
 * @since 2019/5/15
 **/
public class LombokCleanup {

    @SneakyThrows
    public static void main(String[] args) {
        @Cleanup InputStreamReader reader = new InputStreamReader(LombokCleanup.class.getResourceAsStream("/test.txt"));
        char[] chars = new char[1024];
        while (true) {
            int r = reader.read(chars);
            if (r == -1) {
                break;
            }
            for (char c : chars) {
                if (c != 0) {
                    System.out.print(c);
                }
            }
        }
        // we dont need write code 'reader.close()', it will compile automatically by lombok
    }
}
