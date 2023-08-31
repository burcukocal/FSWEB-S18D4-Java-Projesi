package com.workintech.mapping.service;

import com.workintech.mapping.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account find(int id);
    Account save(Account account);
    void delete(Account account);
}
