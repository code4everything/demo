package org.code4everything.demo.guava.base;

import com.google.common.base.CaseFormat;

/**
 * 字符串大小写转换
 *
 * @author pantao
 * @since 2019/10/4
 */
public class CaseFormatDemo {

    public static void main(String[] args) {
        // 小写中划线转小驼峰
        String[] test = {"case-format-demo", "caseFormatDemo"};
        assert test[1].equals(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, test[0]));
        // 小写下划线转大驼峰
        test = new String[]{"case_format_demo", "CaseFormatDemo"};
        assert test[1].equals(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, test[0]));
        // 大驼峰转大写下划线
        test = new String[]{"CaseFormatDemo", "CASE_FORMAT_DEMO"};
        assert test[1].equals(CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, test[0]));
        // 大驼峰转小写下划线
        test = new String[]{"CaseFormatDemo", "case_format_demo"};
        assert test[1].equals(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, test[0]));
        // 大驼峰转小驼峰
        test = new String[]{"CaseFormatDemo", "caseFormatDemo"};
        assert test[1].equals(CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, test[0]));
    }
}
