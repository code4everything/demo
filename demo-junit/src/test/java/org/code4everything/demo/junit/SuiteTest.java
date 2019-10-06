package org.code4everything.demo.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 测试套件：将一组测试类组合起来一起运行，作为测试类入口，并且此类不包含任何方法
 *
 * @author pantao
 * @since 2019/10/6
 */
// 修改测试运行运行器
@RunWith(Suite.class)
// 传入要运行的测试类
@Suite.SuiteClasses({BaseJunitTest.class, ParameterTest.class})
public class SuiteTest {}
