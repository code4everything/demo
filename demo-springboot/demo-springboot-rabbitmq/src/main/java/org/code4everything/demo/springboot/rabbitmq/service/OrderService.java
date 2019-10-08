package org.code4everything.demo.springboot.rabbitmq.service;

import org.code4everything.demo.springboot.rabbitmq.domain.Order;

/**
 * @author pantao
 * @since 2019/10/8
 */
public interface OrderService {

    void saveOrder(Order order);
}
