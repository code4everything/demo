package org.code4everything.demo.springboot.rabbitmq.service.impl;

import org.code4everything.demo.springboot.rabbitmq.dao.OrderDAO;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.code4everything.demo.springboot.rabbitmq.producer.RabbitProducer;
import org.code4everything.demo.springboot.rabbitmq.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderDAO orderDAO;

    private final RabbitProducer rabbitProducer;

    public OrderServiceImpl(OrderDAO orderDAO, RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
        this.orderDAO = orderDAO;
    }

    @Override
    public void saveOrder(Order order) {
        // 保存业务数据至数据库
        orderDAO.saveOrder(order);
        // 投递消息
        rabbitProducer.publishOrder(order);
    }
}
