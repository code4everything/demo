package org.code4everything.demo.lombok;

import lombok.AccessLevel;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import lombok.experimental.PackagePrivate;

/**
 * @author pantao
 * @since 2019/5/15
 **/
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PUBLIC)
public class LombokFieldDefaults {

    int nationanity = 56;

    @NonFinal
    @PackagePrivate
    int contry = 23;

    public static void main(String[] args) {
        LombokFieldDefaults defaults = new LombokFieldDefaults();
        System.out.println(defaults);
        defaults.contry = 223;
        System.out.println(defaults);
    }
}
