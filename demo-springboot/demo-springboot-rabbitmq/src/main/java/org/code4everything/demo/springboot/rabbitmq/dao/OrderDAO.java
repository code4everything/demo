package org.code4everything.demo.springboot.rabbitmq.dao;

import cn.hutool.core.lang.Console;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.springframework.stereotype.Repository;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Repository
public class OrderDAO {

    public void saveOrder(Order order) {
        // 仅仅是测试，所以这里并没有进行真实的数据库操作
        Console.log("save order[{}] to db", order);
    }
}
