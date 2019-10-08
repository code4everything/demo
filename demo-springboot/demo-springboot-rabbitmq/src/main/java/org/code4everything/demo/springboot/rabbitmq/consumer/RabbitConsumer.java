package org.code4everything.demo.springboot.rabbitmq.consumer;

import cn.hutool.core.lang.Console;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author pantao
 * @since 2019/10/8
 */
@Component
public class RabbitConsumer {

    /**
     * 保证消费端的幂等性，实际开发中一般使用数据库或Redis缓存持久化
     */
    private final Set<Order> consumedOrder = new HashSet<>(8);

    /**
     * 手动签收消息时需要用到 {@link Channel}，{@link RabbitListener} 的强大之处在于它会帮我们自动创建exchange和queue并用routingKey绑定
     */
    @RabbitHandler
    // @formatter:off
    @RabbitListener(bindings = @QueueBinding(
            // 监听的队列
            value = @Queue(value = "order-queue", durable = "true"),
            // 监听的交换机
            exchange = @Exchange(name = "order-exchange", type = "topic"),
            // 监听的路由
            key = "order.routing.key"))
    // @formatter:on
    public void onMessage(@Payload String order, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        Order orderObject = JSON.parseObject(order, Order.class);
        if (consumedOrder.add(orderObject)) {
            // 保证消费的幂等性
            Console.log("----------收到消息，开始消费---------");
            Console.log(order);
        }
        // 收到签收，告诉rabbitmq消息已被消费
        long deliveryTag = (long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);
    }
}
