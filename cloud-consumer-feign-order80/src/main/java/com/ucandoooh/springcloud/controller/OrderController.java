package com.ucandoooh.springcloud.controller;

import com.ucandoooh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zxn
 * @date 2021/6/21 14:25
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/consumer/payment/openFeign")
    public String openFeign() {
        return "consumer : " + paymentService.openFeign();
    }

    @GetMapping("/consumer/payment/openFeign/timeout")
    public String openFeignTimeOut() {
        return "consumer time out test : " + paymentService.openFeignTimeOut();
    }
}
