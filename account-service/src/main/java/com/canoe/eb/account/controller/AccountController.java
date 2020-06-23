package com.canoe.eb.account.controller;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.account.bean.vo.RegisterVO;
import com.canoe.eb.common.entity.ResEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static com.canoe.eb.common.entity.ResEntity.ok;

@Api(tags="账号服务")
@RestController
@RequestMapping("account")
public class AccountController {

    @ApiOperation("账号注册")
    @ApiResponse(code=200, message = "注册成功")
    @PostMapping("register")
    public ResEntity<RegisterVO> register(@RequestBody AccountRegisterDTO dto) {


        RegisterVO vo = new RegisterVO();
        vo.setAccount(dto.getAccount());
        vo.setRole(dto.getRole());
        return ok(vo);
    }
}