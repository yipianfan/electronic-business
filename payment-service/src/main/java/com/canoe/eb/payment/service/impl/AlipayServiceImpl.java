package com.canoe.eb.payment.service.impl;

import com.canoe.eb.common.entity.ResEntity;
import com.canoe.eb.payment.bean.vo.AccountInfoVO;
import com.canoe.eb.payment.feign.AccountFeign;
import com.canoe.eb.payment.service.AlipayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlipayServiceImpl implements AlipayService {
    @Autowired
    private AccountFeign accountFeign;

    @Override
    public ResEntity<AccountInfoVO> findAccountByEmail(String email) {
        return accountFeign.findAccountByEmail(email);
    }
}