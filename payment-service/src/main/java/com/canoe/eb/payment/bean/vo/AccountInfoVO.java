package com.canoe.eb.payment.bean.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;

@ApiModel
public class AccountInfoVO {
    @ApiModelProperty("email")
    private String account;

    @ApiModelProperty("角色 1->买家  2->商家")
    private Byte role;

    @ApiModelProperty("注册时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createAt;

    public String getAccount() {return account;}

    public void setAccount(String account) {this.account = account;}

    public Byte getRole() {return role;}

    public void setRole(Byte role) {this.role = role;}

    public LocalDateTime getCreateAt() {return createAt;}

    public void setCreateAt(LocalDateTime createAt) {this.createAt = createAt;}
}