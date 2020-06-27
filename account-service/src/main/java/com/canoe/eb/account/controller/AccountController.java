package com.canoe.eb.account.controller;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.account.bean.vo.AccountInfoVO;
import com.canoe.eb.account.bean.vo.AccountRegisterVO;
import com.canoe.eb.account.service.AccountService;
import com.canoe.eb.common.entity.ResEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation("根据email查询账号信息")
    @ApiImplicitParam(name="email", value="email", required = true)
    @GetMapping("accountByEmail")
    public ResEntity<AccountInfoVO> findAccountByEmail(String email) {
        AccountInfoVO vo = accountService.findAccountByEmail(email);
        return ok(vo);
    }
}