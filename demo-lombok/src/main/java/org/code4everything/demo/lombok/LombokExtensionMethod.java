package org.code4everything.demo.lombok;

import cn.hutool.core.lang.Console;
import lombok.experimental.ExtensionMethod;
import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * @author pantao
 * @since 2019/5/15
 **/
@UtilityClass
@ExtensionMethod(Arrays.class)
public class LombokExtensionMethod {

    public static void main(String[] args) {
        long[] array = new long[]{2, 5, 9, 7};
        // it works
        array.sort();
        Console.log(array);
    }
}
