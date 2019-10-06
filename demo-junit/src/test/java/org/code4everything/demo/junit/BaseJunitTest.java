package org.code4everything.demo.junit;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * @author pantao
 * @since 2019/10/6
 */
// 这是默认的测试运行器（可不写，这里只是为了说明我们可以更改测试运行器，比如：SpringRunner）
@RunWith(JUnit4.class)
public class BaseJunitTest {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("@BeforeClass: 修饰静态方法，在所有测试方法之前运行（包括被@Before标记的方法），且仅运行一次");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("@AfterClass: 修饰静态方法，在所有测试方法之后运行（包括被@After标记的方法），且仅运行一次");
    }

    @Before
    public void before() {
        System.out.println("@Before: 在每个测试方法被执行之前都会运行一次");
    }

    @After
    public void after() {
        System.out.println("@After: 在每个测试方法被执行之后都会运行一次");
    }

    /**
     * Test注解：expected表示预期抛出的异常，timeout表示方法超时时长（单位毫秒）
     */
    @Test(expected = ArithmeticException.class, timeout = 1000)
    public void testJunit() {
        assertEquals(1, 6 / 0);
    }

    /**
     * 被Ignore注解标记的测试方法会被执行但测试结果将被忽略
     */
    @Test
    @Ignore("ignore")
    public void testIgnore() {
        System.out.println("ignore");
    }
}
