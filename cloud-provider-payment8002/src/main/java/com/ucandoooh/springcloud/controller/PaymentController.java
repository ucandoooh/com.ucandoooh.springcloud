package com.ucandoooh.springcloud.controller;

import com.ucandoooh.springcloud.entities.CommonResult;
import com.ucandoooh.springcloud.entities.Payment;
import com.ucandoooh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author ucandoooh
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private int port;

    @PostMapping("/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("--插入结果:{}", result);
        if (result > 0) {
            return new CommonResult<>(200, "插入成功==>>" + port, payment);
        } else {
            return new CommonResult<>(404, "插入失败==>>" + port);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        if (null != payment) {
            return new CommonResult<>(200, "查询成功==>>" + port, payment);
        } else {
            return new CommonResult<>(404, "没有对应数据==>>" + port);
        }
    }
}
