package com.ucandoooh.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zxn
 * @date 2021/6/22 14:33
 */
@Component
public class PaymentServiceFallback implements PaymentService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentServiceFallback ===>>> paymentInfo_OK ===> id:" + id;
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentServiceFallback ===>>> paymentInfo_TimeOut ===> id:" + id;
    }
}
