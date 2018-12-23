package com.amtkxa.springbootreladomosimple.domain.repository;

import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;
import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;
import com.amtkxa.springbootreladomosimple.domain.entity.Account;
import com.amtkxa.springbootreladomosimple.domain.entity.AccountList;

/**
 * Interface that represents a Repository for getting {@link Account} related data.
 */
public interface AccountRepository {

  AccountList findByAccountId(int accountId);

  AccountList create(AccountView accountView);

  AccountList deposit(TransactionView transactionView);

  AccountList withdrawal(TransactionView transactionView);

  void terminate(int accountId);
}
