package com.canoe.eb.account.bean.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AccountRegisterVO {
    @ApiModelProperty("用户的唯一标志")
    private Long id;
    @ApiModelProperty("用于注册的email")
    private String account;
    @ApiModelProperty("角色 1->买家  2->商家")
    private Byte role;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getAccount() {return account;}

    public void setAccount(String account) {this.account = account;}

    public Byte getRole() {return role;}

    public void setRole(Byte role) {this.role = role;}
}