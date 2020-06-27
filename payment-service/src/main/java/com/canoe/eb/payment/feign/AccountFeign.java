package com.canoe.eb.payment.feign;

import com.canoe.eb.common.entity.ResEntity;
import com.canoe.eb.payment.bean.vo.AccountInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="account-service", path = "account")
public interface AccountFeign {

    /**
     * 根据email查询账号信息
     */
    @GetMapping("accountByEmail")
    ResEntity<AccountInfoVO> findAccountByEmail(@RequestParam String email);
}