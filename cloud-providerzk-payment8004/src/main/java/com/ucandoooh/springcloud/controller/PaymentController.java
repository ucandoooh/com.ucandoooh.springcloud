package com.ucandoooh.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ucandoooh
 * @data 2021/6/20 13:32
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/zk")
    public String paymentZk() {
        return "spring cloud with zookeeper : " + serverPort + " : " + UUID.randomUUID().toString();
    }
}
