package org.code4everything.demo.junit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * 定义测试用例
 *
 * @author pantao
 * @since 2019/10/6
 */
// 修改测试运行器
@RunWith(Parameterized.class)
public class ParameterTest {

    private String expected;

    private String input1;

    private String input2;

    public ParameterTest(String expected, String input1, String input2) {
        this.expected = expected;
        this.input1 = input1;
        this.input2 = input2;
    }

    /**
     * Parameters注解修饰一个提供测试用例的静态方法
     */
    @Parameterized.Parameters
    public static Collection<String[]> cases() {
        return Arrays.asList(new String[][]{{"ab", "a", "b"}, {"xy", "x", "y"}});
    }

    @Test
    public void testParam() {
        Assert.assertEquals(expected, input1 + input2);
    }
}
