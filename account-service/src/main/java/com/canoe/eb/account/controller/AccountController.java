package com.canoe.eb.account.controller;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.account.bean.vo.AccountRegisterVO;
import com.canoe.eb.account.service.AccountService;
import com.canoe.eb.common.entity.ResEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.canoe.eb.common.entity.ResEntity.ok;

@Api(tags="账号服务")
@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @ApiOperation("账号注册")
    @PostMapping("register")
    public ResEntity<AccountRegisterVO> register(@RequestBody AccountRegisterDTO dto) {
        AccountRegisterVO vo = accountService.register(dto);
        return ok(vo);
    }
}