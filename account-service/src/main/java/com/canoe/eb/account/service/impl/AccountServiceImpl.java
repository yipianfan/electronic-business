package com.canoe.eb.account.service.impl;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.account.bean.entity.Account;
import com.canoe.eb.account.bean.vo.AccountRegisterVO;
import com.canoe.eb.account.mapper.AccountMapper;
import com.canoe.eb.account.service.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public AccountRegisterVO register(AccountRegisterDTO dto) {
        Account account = new Account();
        BeanUtils.copyProperties(dto, account);
        accountMapper.save(account);
        AccountRegisterVO vo = new AccountRegisterVO();
        BeanUtils.copyProperties(account, vo);
        return vo;
    }
}