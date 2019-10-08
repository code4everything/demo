package org.code4everything.demo.springboot.rabbitmq.controller;

import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.code4everything.boot.web.mvc.BaseController;
import org.code4everything.boot.web.mvc.Response;
import org.code4everything.demo.springboot.rabbitmq.domain.Order;
import org.code4everything.demo.springboot.rabbitmq.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author pantao
 * @since 2019/10/8
 */
@RestController
@RequestMapping("/order")
@Api(tags = "订单接口")
public class OrderController extends BaseController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {this.orderService = orderService;}

    @PostMapping("/create")
    @ApiOperation("创建订单")
    @ApiImplicitParam(name = "desc", value = "订单描述")
    public Response<Order> createOrder(@RequestParam String desc) {
        Order order = new Order().setCreateTime(LocalDateTime.now()).setDesc(desc).setId(IdUtil.simpleUUID());
        orderService.saveOrder(order);
        return successResult(order);
    }
}
