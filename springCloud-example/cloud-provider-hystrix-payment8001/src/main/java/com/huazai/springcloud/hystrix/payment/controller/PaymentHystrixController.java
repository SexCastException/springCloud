package com.huazai.springcloud.hystrix.payment.controller;

import com.huazai.springcloud.hystrix.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author pyh
 * @date 2020/7/23 22:31
 */
@RestController
@Slf4j
@RequestMapping("/payment/hystrix")
public class PaymentHystrixController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/paymentInfo_ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Long id) {
        return "result：" + paymentService.paymentInfoOK(id);
    }

    @GetMapping("/paymentInfo_timeout/{id}")
    public String paymentInfoTimeout(@PathVariable("id") Long id) {
        return "result：" + paymentService.paymentInfoTimeout(id);
    }

    //===服务熔断
    @GetMapping("/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Long id) {
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:" + result);
        return result;
    }
}
