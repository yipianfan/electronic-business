package com.canoe.eb.account.mapper;

import com.canoe.eb.account.bean.entity.Account;

public interface AccountMapper {

    int save(Account account);

    Account find(Account account);
}