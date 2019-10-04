// @formatter:off

/**
 * 1. 模式：创建型
 * 2. 定义：提供创建一系列相关或相互依赖的对象接口
 * 3. 场景：客户端不依赖产品实例创建、组合、表达的细节，系统中有多于一个产品族
 * 4. 优点：隔离了具体类的生成过程，实现了高内聚低耦合的目的，符合“开闭原则”的类设计原则
 * 5. 缺点：新增新的产品对象时，难以扩展
 *
 * @author pantao
 * @since 2019/10/4
 */
package org.code4everything.demo.pattern.abstractfactory;
