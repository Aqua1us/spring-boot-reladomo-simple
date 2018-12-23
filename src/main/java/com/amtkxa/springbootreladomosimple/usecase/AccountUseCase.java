package com.amtkxa.springbootreladomosimple.usecase;

import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;
import com.amtkxa.springbootreladomosimple.adapter.view.TransactionView;

import java.util.List;

public interface AccountUseCase {

  /**
   * Retrieve an account with an accountId.
   *
   * @parm accountId
   * @return list of AccountView
   */
  List<? extends AccountView> findByAccountId(int accountId);

  /**
   * Create an account.
   *
   * @parm accountView
   * @return list of AccountView
   */
  List<? extends AccountView> create(AccountView accountView);

  /**
   * Depositing cash into a registered account.
   *
   * @parm transactionView
   * @return list of AccountView
   */
  List<? extends AccountView> deposit(TransactionView transactionView);

  /**
   * Taking cash out of a registered account.
   *
   * @parm transactionView
   * @return list of AccountView
   */
  List<? extends AccountView> withdrawal(TransactionView transactionView);

  /**
   * Terminate an account.
   *
   * @parm accountId
   * @return list of AccountView
   */
  void terminate(int accountId);
}
