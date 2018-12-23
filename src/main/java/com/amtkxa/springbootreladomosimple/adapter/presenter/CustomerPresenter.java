package com.amtkxa.springbootreladomosimple.adapter.presenter;

import com.amtkxa.springbootreladomosimple.adapter.view.CustomerView;
import com.amtkxa.springbootreladomosimple.domain.entity.CustomerList;

import java.util.List;

public interface CustomerPresenter {
  /**
   * It retrieves data from repositories (Customer model), and formats it for returns a response.
   *
   * @parm customerList
   * @return list of CustomerView
   */
  List<? extends CustomerView> response(CustomerList customerList);
}
