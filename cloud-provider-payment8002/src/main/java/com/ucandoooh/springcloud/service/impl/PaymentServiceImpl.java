package com.ucandoooh.springcloud.service.impl;

import com.ucandoooh.springcloud.dao.PaymentDao;
import com.ucandoooh.springcloud.entities.Payment;
import com.ucandoooh.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ucandoooh
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
