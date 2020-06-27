package com.canoe.eb.account.service;

import com.canoe.eb.account.bean.dto.AccountRegisterDTO;
import com.canoe.eb.account.bean.vo.AccountInfoVO;
import com.canoe.eb.account.bean.vo.AccountRegisterVO;

public interface AccountService {

    AccountRegisterVO register(AccountRegisterDTO dto);

    AccountInfoVO findAccountByEmail(String email);
}