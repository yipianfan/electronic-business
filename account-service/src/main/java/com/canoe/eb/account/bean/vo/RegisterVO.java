package com.canoe.eb.account.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class RegisterVO {
    @ApiModelProperty("用于注册的email")
    private String account;
    @ApiModelProperty("角色 1->买家  2->商家")
    private Integer role;

    public String getAccount() {return account;}

    public void setAccount(String account) {this.account = account;}

    public Integer getRole() {return role;}

    public void setRole(Integer role) {this.role = role;}
}