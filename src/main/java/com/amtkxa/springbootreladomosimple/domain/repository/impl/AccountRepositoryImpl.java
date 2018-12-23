package com.amtkxa.springbootreladomosimple.domain.repository.impl;

import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;
import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;
import com.amtkxa.springbootreladomosimple.domain.entity.Account;
import com.amtkxa.springbootreladomosimple.domain.entity.AccountFinder;
import com.amtkxa.springbootreladomosimple.domain.entity.AccountList;
import com.amtkxa.springbootreladomosimple.domain.repository.AccountRepository;
import com.gs.fw.common.mithra.finder.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * {@link AccountRepository} to retrieve and update account data.
 */
@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

  @Override
  public AccountList findByAccountId(int accountId) {
    return AccountFinder.findMany(AccountFinder.accountId().eq(accountId));
  }

  @Override
  public AccountList create(AccountView accountView) {
    Account account = new Account(accountView);
    account.insert();
    return new AccountList(account);
  }

  @Override
  public AccountList deposit(TransactionView transactionView) {
    Account account = AccountFinder.findOne(AccountFinder.accountId().eq(transactionView.getAccountId()));
    account.setBalance(account.getBalance() + transactionView.getAmount());
    return new AccountList(account);
  }

  @Override
  public AccountList withdrawal(TransactionView transactionView) {
    Account account = AccountFinder.findOne(AccountFinder.accountId().eq(transactionView.getAccountId()));
    account.setBalance(account.getBalance() + transactionView.getAmount() * -1);
    return new AccountList(account);
  }

  @Override
  public void terminate(int accountId) {
    Operation op1 = AccountFinder.accountId().eq(accountId);
    Operation op2 = AccountFinder.processingDate().equalsInfinity();
    Account account = AccountFinder.findOne(op1.and(op2));
    account.terminate();
  }
}
