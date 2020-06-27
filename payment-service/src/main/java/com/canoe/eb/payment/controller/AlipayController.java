package com.canoe.eb.payment.controller;

import com.canoe.eb.common.entity.ResEntity;
import com.canoe.eb.payment.bean.vo.AccountInfoVO;
import com.canoe.eb.payment.service.AlipayService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.canoe.eb.common.entity.ResEntity.ok;

@RestController
@RequestMapping("pay")
public class AlipayController {
    @Autowired
    private AlipayService alipayService;

    @PostMapping("alipay")
    public ResEntity<String> pay(String amount) {
        return ok(amount);
    }

    @ApiOperation("根据email查询账号信息")
    @ApiImplicitParam(name="email", value="email", required = true)
    @GetMapping("accountByEmail")
    public ResEntity<AccountInfoVO> findAccountByEmail(String email) {
        return alipayService.findAccountByEmail(email);
    }
}