package org.example;

import org.example.config.AppConfig;
import org.example.model.Order;
import org.example.service.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 初始化Spring容器
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 获取OrderService实例
        OrderService orderService = context.getBean(OrderService.class);

        // 测试订单服务
        System.out.println("===== 创建订单 =====");
        Order order1 = orderService.createOrder("张三", "笔记本电脑", 5999.99);
        Order order2 = orderService.createOrder("李四", "智能手机", 3999.99);

        System.out.println("\n===== 获取所有订单 =====");
        orderService.getAllOrders().forEach(System.out::println);

        System.out.println("\n===== 根据ID获取订单 =====");
        Order foundOrder = orderService.getOrderById(order1.getId());
        System.out.println(foundOrder);

        System.out.println("\n===== 取消订单 =====");
        orderService.cancelOrder(order2.getId());
        System.out.println("取消后的订单列表:");
        orderService.getAllOrders().forEach(System.out::println);
    }
}