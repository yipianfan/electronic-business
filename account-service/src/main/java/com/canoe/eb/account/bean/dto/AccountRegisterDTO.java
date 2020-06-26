package com.canoe.eb.account.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccountRegisterDTO {
    @ApiModelProperty(value="用于注册的email", required=true)
    private String account;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty("角色 1->买家  2->商家")
    private Byte role;
    @ApiModelProperty(value = "验证码", required = true)
    private String captcha;

    public String getAccount() {return account;}

    public void setAccount(String account) {this.account = account;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Byte getRole() {return role;}

    public void setRole(Byte role) {this.role = role;}

    public String getCaptcha() {return captcha;}

    public void setCaptcha(String captcha) {this.captcha = captcha;}
}