// @formatter:off

/**
 * 1. 模式：创建型
 * 2. 定义：通过拷贝原型创建新的对象
 * 3. 场景：资源优化场景，类初始化需要消耗较多的资源时
 * 4. 优点：提高了系统性能，跳过了构造函数的约束
 * 5. 缺点：必须实现Cloneable接口
 *
 * @author pantao
 * @since 2019/10/4
 */
package org.code4everything.demo.pattern.prototype;
