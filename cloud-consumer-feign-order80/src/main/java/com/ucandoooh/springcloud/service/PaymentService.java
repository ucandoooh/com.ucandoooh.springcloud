package com.ucandoooh.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zxn
 * @date 2021/6/21 14:17
 */
@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/openFeign")
    String openFeign();

    @GetMapping("/payment/openFeign/timeout")
    String openFeignTimeOut();

}
