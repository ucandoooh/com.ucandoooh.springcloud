package com.ucandoooh.springcloud.service;

import com.ucandoooh.springcloud.entities.Payment;

public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(Long id);
}
