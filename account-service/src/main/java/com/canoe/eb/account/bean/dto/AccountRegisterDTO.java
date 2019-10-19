package com.canoe.eb.account.bean.dto;

public class AccountRegisterDTO {
    private String account; // email
    private String password;
    private Integer role; // 1->买家  2->商家
    private String captcha;

    public String getAccount() {return account;}

    public void setAccount(String account) {this.account = account;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public Integer getRole() {return role;}

    public void setRole(Integer role) {this.role = role;}

    public String getCaptcha() {return captcha;}

    public void setCaptcha(String captcha) {this.captcha = captcha;}
}