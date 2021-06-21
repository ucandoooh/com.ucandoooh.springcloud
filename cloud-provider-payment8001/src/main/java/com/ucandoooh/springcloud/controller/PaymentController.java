package com.ucandoooh.springcloud.controller;

import com.ucandoooh.springcloud.entities.CommonResult;
import com.ucandoooh.springcloud.entities.Payment;
import com.ucandoooh.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author ucandoooh
 */
@Slf4j
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;

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

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            log.info("service:{}", service);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            log.info("serviceId:{}, host:{}, port:{}, uri{}",
                    instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri());
        });

        return discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String myLoadBalance() {
        return port;
    }

    @GetMapping("/payment/openFeign")
    public String openFeign() {
        return port;
    }

    @GetMapping("/payment/openFeign/timeout")
    public String openFeignTimeOut() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }


}
