package com.canoe.eb.account.controller;

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
    public ResEntity<Map<String, String>> register(@RequestParam String account,
                                                   @RequestParam String password) {
        Map<String, String> map = new HashMap<>();
        map.put("account", account);
        map.put("password", password);
        return ok(map);
    }
}