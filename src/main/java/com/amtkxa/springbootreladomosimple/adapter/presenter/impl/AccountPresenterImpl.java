package com.amtkxa.springbootreladomosimple.adapter.presenter.impl;

import com.amtkxa.springbootreladomosimple.adapter.presenter.AccountPresenter;
import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;
import com.amtkxa.springbootreladomosimple.domain.entity.AccountList;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AccountPresenterImpl implements AccountPresenter {
  /**
   * {@inheritDoc}
   */
  public List<? extends AccountView> response(AccountList accountList) {
    return accountList
        .stream()
        .filter(c -> c != null)
        .map(c -> AccountView.fromAccount(c))
        .collect(Collectors.toList());
  }
}
