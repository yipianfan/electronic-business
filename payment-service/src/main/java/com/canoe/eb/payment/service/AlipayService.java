package com.canoe.eb.payment.service;

import com.canoe.eb.common.entity.ResEntity;
import com.canoe.eb.payment.bean.vo.AccountInfoVO;

public interface AlipayService {

    ResEntity<AccountInfoVO> findAccountByEmail(String email);
}