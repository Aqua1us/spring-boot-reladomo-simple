package com.amtkxa.springbootreladomosimple.adapter.presenter;

import com.amtkxa.springbootreladomosimple.adapter.view.AccountView;
import com.amtkxa.springbootreladomosimple.domain.entity.AccountList;

import java.util.List;

public interface AccountPresenter {
  /**
   * It retrieves data from repositories (Account model), and formats it for returns a response.
   *
   * @parm accountList
   * @return list of AccountView
   */
  List<? extends AccountView> response(AccountList accountList);
}
