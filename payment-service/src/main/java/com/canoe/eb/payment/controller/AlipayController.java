package com.canoe.eb.payment.controller;

import com.canoe.eb.common.entity.ResEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.canoe.eb.common.entity.ResEntity.ok;

@RestController
@RequestMapping("pay")
public class AlipayController {

    @PostMapping("alipay")
    public ResEntity<String> pay(String amount) {
        return ok(amount);
    }
}