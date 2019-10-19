package com.canoe.eb.account.controller;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.common.entity.ResEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.canoe.eb.common.entity.ResEntity.ok;

@RestController
@RequestMapping("account")
public class AccountController {

    @PostMapping("register")
    public ResEntity<Map<String, Object>> register(AccountRegisterDTO dto) {


        Map<String, Object> result = new HashMap<>(2);
        result.put("account", dto.getAccount());
        result.put("role", dto.getRole());
        return ok(result);
    }
}