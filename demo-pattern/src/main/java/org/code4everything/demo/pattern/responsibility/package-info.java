// @formatter:off

/**
 * 1. 模式：行为型
 * 2. 定义：为请求创建一个接受者对象的链
 * 3. 场景：多个对象处理同一个请求
 * 4. 优点：降低了耦合度，简化了对象，使对象不需要知道链的结构，增加新的处理类很方便
 * 5. 缺点：不能保证一定被结构，对系统性能有一定影响
 *
 * @author pantao
 * @since 2019/10/4
 */
package org.code4everything.demo.pattern.responsibility;
